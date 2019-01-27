/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.controller.master;

import com.id.sigada.dao.KomisiDao;
import com.id.sigada.entities.RmKms;
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
public class KomisiController {
    @Autowired private KomisiDao dao;
    
    @RequestMapping("/komisi/list")
    public String daftarKepel(Model m, @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(name = "search", required = false) String search) {

        if (search != null) {
            m.addAttribute("search", search);
            m.addAttribute("komisi", dao.findByKmnamContainingIgnoreCase(search, pageable));
        } else {
            m.addAttribute("komisi", dao.findAll(pageable));
        }
        return "komisi/list";
    }

    @GetMapping("/komisi/form")
    public ModelMap tampilkanForm(@RequestParam(value = "id", required = false) String id) {
        RmKms komisi;       

        if (id == null) {
            komisi = new RmKms();
        } else {
            komisi = dao.findById(id).orElse(new RmKms());
        }

        return new ModelMap("komisi", komisi);
    }

    @PostMapping("/komisi/form")
    public String prosesForm(@ModelAttribute @Valid RmKms komisi, BindingResult errors, SessionStatus status) {
        if (errors.hasErrors()) {
            return "komisi/form";
        }

        dao.save(komisi);
        status.setComplete();
        return "redirect:list";
    }

    @GetMapping("/komisi/delete{id}")
    public String hapusData(@RequestParam(value = "id", required = false) String id) {
        dao.deleteById(id);

        return "redirect:/komisi/list";

    }
}
