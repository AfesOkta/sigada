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
@Table(name = "rmkms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RmKms.findAll", query = "SELECT r FROM RmKms r")
    , @NamedQuery(name = "RmKms.findByKmkod", query = "SELECT r FROM RmKms r WHERE r.kmkod = :kmkod")
    , @NamedQuery(name = "RmKms.findByKmnam", query = "SELECT r FROM RmKms r WHERE r.kmnam = :kmnam")
    , @NamedQuery(name = "RmKms.findByKmsng", query = "SELECT r FROM RmKms r WHERE r.kmsng = :kmsng")})
public class RmKms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
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

    public RmKms() {
    }

    public RmKms(String kmkod) {
        this.kmkod = kmkod;
    }

    public String getKmkod() {
        return kmkod;
    }

    public void setKmkod(String kmkod) {
        this.kmkod = kmkod;
    }

    public String getKmnam() {
        return kmnam;
    }

    public void setKmnam(String kmnam) {
        this.kmnam = kmnam;
    }

    public String getKmsng() {
        return kmsng;
    }

    public void setKmsng(String kmsng) {
        this.kmsng = kmsng;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kmkod != null ? kmkod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RmKms)) {
            return false;
        }
        RmKms other = (RmKms) object;
        if ((this.kmkod == null && other.kmkod != null) || (this.kmkod != null && !this.kmkod.equals(other.kmkod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.id.sigada.entities.RmKms[ kmkod=" + kmkod + " ]";
    }
    
}
