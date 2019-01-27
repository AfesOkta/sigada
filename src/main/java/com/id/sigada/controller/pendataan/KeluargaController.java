/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.controller.pendataan;

import com.id.sigada.dao.KeluargaDao;
import com.id.sigada.dao.KepelDao;
import com.id.sigada.entities.RmKel;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
public class KeluargaController {
    @Autowired private KeluargaDao dao;
    @Autowired private KepelDao kepelDao;
    
    @RequestMapping("/keluarga/list")
    public String daftarKepel(Model m, @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(name = "search", required = false) String search) {

        if (search != null) {
            m.addAttribute("search", search);
            m.addAttribute("keluarga", dao.findByKlnamContainingIgnoreCase(search, pageable));
        } else {
            m.addAttribute("keluarga", dao.findAll(pageable));
        }
        return "keluarga/list";
    }

    @GetMapping("/keluarga/form")
    public void tampilkanForm(Model model,@RequestParam(value = "id", required = false) String id) {
        RmKel keluarga;       

        if (id == null) {
            keluarga = new RmKel();
            keluarga.setKlkod(getMaxKlkod());
        } else {
            keluarga = dao.findById(id).orElse(new RmKel());
        }
        model.addAttribute("keluarga", keluarga);
        model.addAttribute("listKepel",kepelDao.findAll());
    }

    @PostMapping("/keluarga/form")
    public String prosesForm(@ModelAttribute @Valid RmKel keluarga, BindingResult errors, SessionStatus status) {
        if (errors.hasErrors()) {
            return "keluarga/form";
        }        
        dao.save(keluarga);
        status.setComplete();
        return "redirect:list";
    }

    @GetMapping("/keluarga/delete{id}")
    public String hapusData(@RequestParam(value = "id", required = false) String id) {
        dao.deleteById(id);

        return "redirect:/keluarga/list";

    }
    
    /**
     * 
     * @return Max Kode Keluarga
     */
    private String getMaxKlkod() {
        String id;
        String maxKode = dao.getMaxKode();
        if ("0".equals(maxKode)) {
            return "0001";
        } else {
            id = String.valueOf(Integer.valueOf(maxKode) + 1);
        }
        String comCod = "";
        switch (id.length()) {
            case 1:
                id = "0000" + id;
                break;
            case 2:
                id = "000" + id;
                break;
            case 3:
                id = "00" + id;
                break;
            case 4:
                id = "0" + id;
                break;            
        }
        comCod = id;
        return comCod;
    }
}
