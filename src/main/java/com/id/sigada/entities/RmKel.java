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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Afes
 */
@Entity
@Table(name = "rmkel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RmKel.findAll", query = "SELECT r FROM RmKel r")
    , @NamedQuery(name = "RmKel.findByKlkod", query = "SELECT r FROM RmKel r WHERE r.klkod = :klkod")
    , @NamedQuery(name = "RmKel.findByKlnam", query = "SELECT r FROM RmKel r WHERE r.klnam = :klnam")
    , @NamedQuery(name = "RmKel.findByKlkkk", query = "SELECT r FROM RmKel r WHERE r.klkkk = :klkkk")
    , @NamedQuery(name = "RmKel.findByKpkod", query = "SELECT r FROM RmKel r WHERE r.kpkod = :kpkod")})
public class RmKel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
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
    @Size(max = 2)
    @Column(name = "kpkod")
    private String kpkod;

    public RmKel() {
    }

    public RmKel(String klkod) {
        this.klkod = klkod;
    }

    public String getKlkod() {
        return klkod;
    }

    public void setKlkod(String klkod) {
        this.klkod = klkod;
    }

    public String getKlnam() {
        return klnam;
    }

    public void setKlnam(String klnam) {
        this.klnam = klnam;
    }

    public String getKlkkk() {
        return klkkk;
    }

    public void setKlkkk(String klkkk) {
        this.klkkk = klkkk;
    }

    public String getKpkod() {
        return kpkod;
    }

    public void setKpkod(String kpkod) {
        this.kpkod = kpkod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (klkod != null ? klkod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RmKel)) {
            return false;
        }
        RmKel other = (RmKel) object;
        if ((this.klkod == null && other.klkod != null) || (this.klkod != null && !this.klkod.equals(other.klkod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.id.sigada.entities.RmKel[ klkod=" + klkod + " ]";
    }
    
}
