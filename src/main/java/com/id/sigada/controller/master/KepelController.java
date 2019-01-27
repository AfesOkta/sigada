/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.controller.master;

import com.id.sigada.dao.KepelDao;
import com.id.sigada.entities.RmKpl;
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
public class KepelController {
    @Autowired private KepelDao dao;
    
    @RequestMapping("/kepel/list")
    public String daftarKepel(Model m, @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(name = "search", required = false) String search) {

        if (search != null) {
            m.addAttribute("search", search);
            m.addAttribute("kepel", dao.findByKpnamContainingIgnoreCase(search, pageable));
        } else {
            m.addAttribute("kepel", dao.findAll(pageable));
        }
        return "kepel/list";
    }

    @GetMapping("/kepel/form")
    public ModelMap tampilkanForm(@RequestParam(value = "id", required = false) String id) {
        RmKpl kepel;       

        if (id == null) {
            kepel = new RmKpl();
        } else {
            kepel = dao.findById(id).orElse(new RmKpl());
        }

        return new ModelMap("kepel", kepel);
    }

    @PostMapping("/kepel/form")
    public String prosesForm(@ModelAttribute @Valid RmKpl kepel, BindingResult errors, SessionStatus status) {
        if (errors.hasErrors()) {
            return "kepel/form";
        }

        dao.save(kepel);
        status.setComplete();
        return "redirect:list";
    }

    @GetMapping("/kepel/delete{id}")
    public String hapusData(@RequestParam(value = "id", required = false) String id) {
        dao.deleteById(id);

        return "redirect:/kepel/list";

    }
}
