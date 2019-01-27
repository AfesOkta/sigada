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
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Afes
 */
@Entity
@Table(name = "rpjps")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RpJps.findAll", query = "SELECT r FROM RpJps r")
    , @NamedQuery(name = "RpJps.findByJmkod", query = "SELECT r FROM RpJps r WHERE r.jmkod = :jmkod")
    , @NamedQuery(name = "RpJps.findByJmnam", query = "SELECT r FROM RpJps r WHERE r.jmnam = :jmnam")
    , @NamedQuery(name = "RpJps.findByJpsid", query = "SELECT r FROM RpJps r WHERE r.jpsid = :jpsid")})
public class RpJps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "jmkod")
    private String jmkod;
    @Size(max = 30)
    @Column(name = "jmnam")
    private String jmnam;
    @Size(max = 30)
    @Column(name = "jpsid")
    private String jpsid;
    
}
