/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.rest;

import com.id.sigada.dao.KeluargaDao;
import com.id.sigada.dao.KepelDao;
import com.id.sigada.entities.RmKel;
import com.id.sigada.entities.RmKpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Afes
 */
@RestController
@RequestMapping("/api/client")
public class KeluargaControllerRest {
    
    @Autowired
    private KeluargaDao keluargaDao;
    @Autowired
    private KepelDao kepelDao;
    
    @RequestMapping(method = RequestMethod.GET, value = "/get/kepel", produces = "application/json")
    public Iterable<RmKpl> getKepel() {
        Iterable<RmKpl> result = kepelDao.findAll();
        return result;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/get/keluarga/{kpkod}", produces = "application/json")
    public List<RmKel> getKeluarga(@PathVariable String kpkod) {
        RmKpl k = kepelDao.findByKpkod(kpkod);
        return keluargaDao.getByKpkod(k);
    }
}
