/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.dao.sec;

import com.id.sigada.entities.Role;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Afes
 */
@Repository("roleRepository")
public interface RoleDao extends PagingAndSortingRepository<Role, String>{
   
}
