/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.dao;

import com.id.sigada.entities.RpJmt;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Afes
 */
@Repository
public interface JemaatDao extends JpaRepository<RpJmt, String>{
    List<RpJmt> findByKlkod(String klkod, Pageable pageable);
    
    @Query("SELECT r FROM RpJmt r WHERE r.klkod = :klkod and r.jmnam = :jmnam")
    Page<RpJmt> findByJmnamContainingIgnoreCase2(@Param("klkod") String klkod,@Param("jmnam")  String jmnam, Pageable pageable);
    
    Page<RpJmt> findByJmnamContainingIgnoreCase(String jmnam, Pageable pageable);
    
    @Query(value="SELECT COALESCE( NULLIF(Max(right(jmkod,2)),''), '0' ) as maxkode FROM RpJmt r WHERE cast(r.jmtgl as varchar) = :jmtgl",nativeQuery = true )
    public String getMaxKode(@Param("jmtgl")  String jmtgl);
}
