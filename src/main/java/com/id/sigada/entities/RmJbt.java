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
@Table(name = "rmjbt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RmJbt.findAll", query = "SELECT r FROM RmJbt r")
    , @NamedQuery(name = "RmJbt.findByJbkod", query = "SELECT r FROM RmJbt r WHERE r.jbkod = :jbkod")
    , @NamedQuery(name = "RmJbt.findByJbnam", query = "SELECT r FROM RmJbt r WHERE r.jbnam = :jbnam")})
public class RmJbt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "jbkod")
    private String jbkod;
    @Size(max = 25)
    @Column(name = "jbnam")
    private String jbnam;

    public RmJbt() {
    }

    public RmJbt(String jbkod) {
        this.jbkod = jbkod;
    }

    public String getJbkod() {
        return jbkod;
    }

    public void setJbkod(String jbkod) {
        this.jbkod = jbkod;
    }

    public String getJbnam() {
        return jbnam;
    }

    public void setJbnam(String jbnam) {
        this.jbnam = jbnam;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jbkod != null ? jbkod.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RmJbt)) {
            return false;
        }
        RmJbt other = (RmJbt) object;
        if ((this.jbkod == null && other.jbkod != null) || (this.jbkod != null && !this.jbkod.equals(other.jbkod))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.id.sigada.entities.RmJbt[ jbkod=" + jbkod + " ]";
    }
    
}
