/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.util;

import com.id.sigada.dao.JemaatDao;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author root
 */
public class GeneratorKode {
    
    public GeneratorKode(){}
    /**
     * 
     * @return Max Kode Jemaat
     */
    public String getMaxKlkod(JemaatDao dao, Date tgl) {
        String id;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-mm-dd");
        SimpleDateFormat sdf = new SimpleDateFormat("yymmdd");
        String maxKode = dao.getMaxKode(sd.format(tgl));        
        if ("0".equals(maxKode)) {
            id = "01";
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
