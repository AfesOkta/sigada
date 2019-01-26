/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Afes
 */
@Entity
@Table(name = "rmkmj")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RmKmj.findAll", query = "SELECT r FROM RmKmj r")
    , @NamedQuery(name = "RmKmj.findByKmprd", query = "SELECT r FROM RmKmj r WHERE r.kmprd = :kmprd")
    , @NamedQuery(name = "RmKmj.findByKmkod", query = "SELECT r FROM RmKmj r WHERE r.kmkod = :kmkod")
    , @NamedQuery(name = "RmKmj.findByKmtgl", query = "SELECT r FROM RmKmj r WHERE r.kmtgl = :kmtgl")
    , @NamedQuery(name = "RmKmj.findByJmkod", query = "SELECT r FROM RmKmj r WHERE r.jmkod = :jmkod")
    , @NamedQuery(name = "RmKmj.findByKmtgs", query = "SELECT r FROM RmKmj r WHERE r.kmtgs = :kmtgs")
    , @NamedQuery(name = "RmKmj.findByKmakt", query = "SELECT r FROM RmKmj r WHERE r.kmakt = :kmakt")})
public class RmKmj implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "kmprd")
    private String kmprd;
    @Size(max = 3)
    @Column(name = "kmkod")
    private String kmkod;
    @Column(name = "kmtgl")
    @Temporal(TemporalType.DATE)
    private Date kmtgl;
    @Size(max = 8)
    @Column(name = "jmkod")
    private String jmkod;
    @Column(name = "kmtgs")
    @Temporal(TemporalType.DATE)
    private Date kmtgs;
    @Column(name = "kmakt")
    private Boolean kmakt;

    public RmKmj() {
    }

    public RmKmj(String kmprd) {
        this.kmprd = kmprd;
    }

    public String getKmprd() {
        return kmprd;
    }

    public void setKmprd(String kmprd) {
        this.kmprd = kmprd;
    }

    public String getKmkod() {
        return kmkod;
    }

    public void setKmkod(String kmkod) {
        this.kmkod = kmkod;
    }

    public Date getKmtgl() {
        return kmtgl;
    }

    public void setKmtgl(Date kmtgl) {
        this.kmtgl = kmtgl;
    }

    public String getJmkod() {
        return jmkod;
    }

    public void setJmkod(String jmkod) {
        this.jmkod = jmkod;
    }

    public Date getKmtgs() {
        return kmtgs;
    }

    public void setKmtgs(Date kmtgs) {
        this.kmtgs = kmtgs;
    }

    public Boolean getKmakt() {
        return kmakt;
    }

    public void setKmakt(Boolean kmakt) {
        this.kmakt = kmakt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kmprd != null ? kmprd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RmKmj)) {
            return false;
        }
        RmKmj other = (RmKmj) object;
        if ((this.kmprd == null && other.kmprd != null) || (this.kmprd != null && !this.kmprd.equals(other.kmprd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.id.sigada.entities.RmKmj[ kmprd=" + kmprd + " ]";
    }
    
}
