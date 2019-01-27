/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.dao.sec;

import com.id.sigada.entities.PasswordReset;
import com.id.sigada.entities.User;
import java.util.Date;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Afes
 */
@Repository
public interface PasswordResetDao extends PagingAndSortingRepository<PasswordReset, String>{
    PasswordReset findByUser(User pengguna);
    
    PasswordReset findByToken(String token);

    @Modifying
    @Query("DELETE PasswordReset prt WHERE prt.expiryDate <= :now")
    void deleteExpiredToken(@Param("now") Date date);
}
