/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
    @Column(name = "kmkod", nullable = false, length = 2)
    private String kmkod;
    @Size(max = 30)
    @Column(name = "kmnam", length = 30)
    private String kmnam;
    @Size(max = 10)
    @Column(name = "kmsng", length = 10)
    private String kmsng;
//    @OneToMany(mappedBy = "idKmkod", fetch = FetchType.LAZY)
//    private List<RpJmt> rpJmtList;
    
    public RmKms(){}
    public RmKms(String id) {
        this.id = id;
    }

    public RmKms(String id, String kmkod) {
        this.id = id;
        this.kmkod = kmkod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RmKms)) {
            return false;
        }
        RmKms other = (RmKms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.id.sigada.entities.RmKms[ id=" + id + " ]";
    }

    
    
}
