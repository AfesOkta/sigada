/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.dao;

import com.id.sigada.entities.RmKms;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Afes
 */
@Repository
public interface KomisiDao extends JpaRepository<RmKms, String>{
    RmKms findByKmkod(String kmkod);
    
    Page<RmKms> findByKmnamContainingIgnoreCase(String kmnam, Pageable pageable);
}
