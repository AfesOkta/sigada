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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Afes
 */
@Entity
@Table(name = "rmkel")
@Data
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RmKel.findAll", query = "SELECT r FROM RmKel r")
    , @NamedQuery(name = "RmKel.findByKlkod", query = "SELECT r FROM RmKel r WHERE r.klkod = :klkod")
    , @NamedQuery(name = "RmKel.findByKlnam", query = "SELECT r FROM RmKel r WHERE r.klnam = :klnam")
    , @NamedQuery(name = "RmKel.findByKlkkk", query = "SELECT r FROM RmKel r WHERE r.klkkk = :klkkk")
    , @NamedQuery(name = "RmKel.findByKpkod", query = "SELECT r FROM RmKel r WHERE r.kpkod = :kpkod")})
public class RmKel implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "klkod")
    private String klkod;
    @Size(max = 40)
    @Column(name = "klnam")
    private String klnam;
    @Size(max = 8)
    @Column(name = "klkkk")
    private String klkkk;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_kpkod")       
    private @Getter @Setter RmKpl kpkod;

}
