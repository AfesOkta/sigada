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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
//@NamedQueries({
//    @NamedQuery(name = "RmKel.findAll", query = "SELECT r FROM RmKel r")
//    , @NamedQuery(name = "RmKel.findByKlkod", query = "SELECT r FROM RmKel r WHERE r.klkod = :klkod")
//    , @NamedQuery(name = "RmKel.findByKlnam", query = "SELECT r FROM RmKel r WHERE r.klnam = :klnam")
//    , @NamedQuery(name = "RmKel.findByKlkkk", query = "SELECT r FROM RmKel r WHERE r.klkkk = :klkkk")
//    , @NamedQuery(name = "RmKel.findByKpkod", query = "SELECT r FROM RmKel r WHERE r.kpkod = :kpkod")})
public class RmKel implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "klkod", nullable = false, length = 4)
    private String klkod;
    @Size(max = 40)
    @Column(name = "klnam", length = 40)
    private String klnam;
    @Size(max = 8)
    @Column(name = "klkkk", length = 8)
    private String klkkk;
//    @OneToMany(mappedBy = "idKlkod", fetch = FetchType.LAZY)
//    private List<RpJmt> rpJmtList;
    
    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_kpkod")       
    private @Getter @Setter RmKpl kpkod;
    
    public RmKel() {}
    
    public RmKel(String id) {
        this.id = id;
    }

    public RmKel(String id, String klkod) {
        this.id = id;
        this.klkod = klkod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RmKel)) {
            return false;
        }
        RmKel other = (RmKel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.id.sigada.entities.RmKel[ id=" + id + " ]";
    }

}
