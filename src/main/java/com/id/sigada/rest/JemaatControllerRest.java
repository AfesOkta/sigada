/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.rest;

import com.id.sigada.dao.JemaatDao;
import com.id.sigada.util.GeneratorKode;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author root
 */
@RestController
@RequestMapping("/api/client/")
public class JemaatControllerRest {
    @Autowired
    private JemaatDao dao;
    @Autowired
    private GeneratorKode gk;
    
    @RequestMapping(method = RequestMethod.GET, value = "/get/jemaat/maxkode/{tgl}", produces = "application/json")
    public String getMaxKode(@PathVariable String tgl) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
            Date vTgl = sdf.parse(tgl);
            return gk.getMaxKlkod(dao, vTgl);
        }catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
        return "";
    }
}
