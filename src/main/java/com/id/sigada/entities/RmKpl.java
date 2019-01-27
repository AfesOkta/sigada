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
@Data
@Table(name = "rmkpl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RmKpl.findAll", query = "SELECT r FROM RmKpl r")
    , @NamedQuery(name = "RmKpl.findByKpkod", query = "SELECT r FROM RmKpl r WHERE r.kpkod = :kpkod")
    , @NamedQuery(name = "RmKpl.findByKpnam", query = "SELECT r FROM RmKpl r WHERE r.kpnam = :kpnam")
    , @NamedQuery(name = "RmKpl.findByKppnt", query = "SELECT r FROM RmKpl r WHERE r.kppnt = :kppnt")
    , @NamedQuery(name = "RmKpl.findByKpdkn", query = "SELECT r FROM RmKpl r WHERE r.kpdkn = :kpdkn")})
public class RmKpl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "kpkod")
    private String kpkod;
    @Size(max = 35)
    @Column(name = "kpnam")
    private String kpnam;
    @Size(max = 8)
    @Column(name = "kppnt")
    private String kppnt;
    @Size(max = 8)
    @Column(name = "kpdkn")
    private String kpdkn;
    
}
