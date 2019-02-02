/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.controller.pendataan;

import com.id.sigada.dao.JemaatDao;
import com.id.sigada.dao.KeluargaDao;
import com.id.sigada.dao.KepelDao;
import com.id.sigada.dao.KomisiDao;
import com.id.sigada.entities.RmKel;
import com.id.sigada.entities.RpJmt;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

/**
 *
 * @author Afes
 */
@Controller
public class JemaatController {
    @Autowired
    private JemaatDao dao;
    @Autowired
    private KeluargaDao keluargaDao;
    @Autowired
    private KomisiDao komisiDao;
    @Autowired
    private KepelDao kepelDao;
    
    @RequestMapping("/jemaat/list")
    public String daftarKepel(Model m, @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(name = "search", required = false) String search) {

        if (search != null) {
            m.addAttribute("search", search);
            m.addAttribute("keluarga", dao.findByJmnamContainingIgnoreCase2(id, search, pageable));
        } else {
            if (id != null) {
                m.addAttribute("keluarga", dao.findByKlkod(id,pageable));
            }else {
                m.addAttribute("keluarga", dao.findAll(pageable));
            }
        }
        return "jemaat/list";
    }
    
    @RequestMapping("/jemaat/listAll")
    public String daftarKepelAll(Model m, @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(name = "search", required = false) String search) {

        if (search != null) {
            m.addAttribute("search", search);
            m.addAttribute("jemaat", dao.findByJmnamContainingIgnoreCase(search, pageable));
        } else {
            m.addAttribute("jemaat", dao.findAll(pageable));
        }
        return "jemaat/list";
    }
    
    @RequestMapping("/jemaat/formAll")
    public void tampilkanFormId(Model model,@RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "klkod", required = false) String klkod) {
        RpJmt rpJmt;       

        if (id == null) {
            rpJmt = new RpJmt();
            rpJmt.setKlkod(klkod);
            if (klkod != null) {
                RmKel kpl = keluargaDao.findByKlkod(klkod);
                if (kpl != null) {
                    rpJmt.setKpkod(kpl.getKpkod());
                }
            }
        } else {
            rpJmt = dao.findById(id).orElse(new RpJmt());
        }
        model.addAttribute("jemaat", rpJmt);  
        model.addAttribute("listKepel",kepelDao.findAll());
        model.addAttribute("listKeluarga", keluargaDao.findAll());
        model.addAttribute("listKomisi", komisiDao.findAll());
    }
    
    @PostMapping("/jemaat/formAll")
    public String prosesForm(@ModelAttribute @Valid RpJmt jemaat, BindingResult errors, SessionStatus status) {
        if (errors.hasErrors()) {
            return "jemaat/formAll";
        } 
        if (jemaat.getJmtgl()!=null) {
            jemaat.setJmkod(getMaxKlkod(jemaat.getJmtgl()));
        }else {
            return "jemaat/formAll";
        }
        dao.save(jemaat);
        status.setComplete();
        return "redirect:list";
    }
    /**
     * 
     * @return Max Kode Jemaat
     */
    private String getMaxKlkod(Date tgl) {
        String id;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yymmdd");
        String maxKode = dao.getMaxKode(sd.format(tgl));        
        if ("0".equals(maxKode)) {
            return "01";
        } else {
            id = String.valueOf(Integer.valueOf(maxKode) + 1);
        }
        String comCod = "";
        switch (id.length()) {
            case 1:
                id = "0" + id;
                break;
            case 2:
                id = id;
                break;                        
        }
        comCod = sdf.format(tgl).concat(id);
        return comCod;
    }
}
