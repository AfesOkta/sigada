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
@Table(name = "rmkms")
@Data
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RmKms.findAll", query = "SELECT r FROM RmKms r")
    , @NamedQuery(name = "RmKms.findByKmkod", query = "SELECT r FROM RmKms r WHERE r.kmkod = :kmkod")
    , @NamedQuery(name = "RmKms.findByKmnam", query = "SELECT r FROM RmKms r WHERE r.kmnam = :kmnam")
    , @NamedQuery(name = "RmKms.findByKmsng", query = "SELECT r FROM RmKms r WHERE r.kmsng = :kmsng")})
public class RmKms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "kmkod")
    private String kmkod;
    @Size(max = 30)
    @Column(name = "kmnam")
    private String kmnam;
    @Size(max = 10)
    @Column(name = "kmsng")
    private String kmsng;

    
    
}
