/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Afes
 */
@Entity
@Table(name = "rmjbt")
@Data
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RmJbt.findAll", query = "SELECT r FROM RmJbt r")
    , @NamedQuery(name = "RmJbt.findByJbkod", query = "SELECT r FROM RmJbt r WHERE r.jbkod = :jbkod")
    , @NamedQuery(name = "RmJbt.findByJbnam", query = "SELECT r FROM RmJbt r WHERE r.jbnam = :jbnam")})
public class RmJbt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "jbkod")
    private String jbkod;
    @Size(max = 25)
    @Column(name = "jbnam")
    private String jbnam;
    
}
