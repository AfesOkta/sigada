/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.dao;

import com.id.sigada.entities.RmKel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Afes
 */
@Repository
public interface KeluargaDao extends JpaRepository<RmKel, String>{
    RmKel findByKlkod(String klkod);
    
    Page<RmKel> findByKlnamContainingIgnoreCase(String klnam, Pageable pageable);
    
    @Query(value="select COALESCE( NULLIF(Max(right(klkod,4)),''), '0' ) from public.rmkel ",nativeQuery = true)
    String getMaxKode();
}
