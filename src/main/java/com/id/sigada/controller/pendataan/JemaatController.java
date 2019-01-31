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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    
}
