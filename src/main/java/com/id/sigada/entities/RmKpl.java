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

    public RmKpl() {
    }

    public RmKpl(String kpkod) {
        this.kpkod = kpkod;
    }

    public String getKpkod() {
        return kpkod;
    }

    public void setKpkod(String kpkod) {
        this.kpkod = kpkod;
    }

    public String getKpnam() {
        return kpnam;
    }

    public void setKpnam(String kpnam) {
        this.kpnam = kpnam;
    }

    public String getKppnt() {
        return kppnt;
    }

    public void setKppnt(String kppnt) {
        this.kppnt = kppnt;
    }

    public String getKpdkn() {
        return kpdkn;
    }

    public void setKpdkn(String kpdkn) {
        this.kpdkn = kpdkn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kpkod != null ? kpkod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RmKpl)) {
            return false;
        }
        RmKpl other = (RmKpl) object;
        if ((this.kpkod == null && other.kpkod != null) || (this.kpkod != null && !this.kpkod.equals(other.kpkod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.id.sigada.entities.RmKpl[ kpkod=" + kpkod + " ]";
    }
    
}
