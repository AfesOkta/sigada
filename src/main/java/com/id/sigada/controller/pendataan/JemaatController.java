/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.controller.pendataan;

import com.id.sigada.dao.JemaatDao;
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
    
    @RequestMapping("/jemaat/list")
    public String daftarKepel(Model m, @PageableDefault(size = 10) Pageable pageable,
            @RequestParam(name = "search", required = false) String search) {

        if (search != null) {
            m.addAttribute("search", search);
            m.addAttribute("jemaat", dao.findByJmnamContainingIgnoreCase(search, pageable));
        } else {
            m.addAttribute("jemaat", dao.findAll(pageable));
        }
        return "jemaat/list";
    }
}
