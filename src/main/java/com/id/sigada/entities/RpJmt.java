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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**
 *
 * @author Afes
 */
@Entity
@Data
@Table(name = "rpjmt")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "RpJmt.findAll", query = "SELECT r FROM RpJmt r")
//    , @NamedQuery(name = "RpJmt.findByJmkod", query = "SELECT r FROM RpJmt r WHERE r.jmkod = :jmkod")
//    , @NamedQuery(name = "RpJmt.findByJmnam", query = "SELECT r FROM RpJmt r WHERE r.jmnam = :jmnam")
//    , @NamedQuery(name = "RpJmt.findByKlkod", query = "SELECT r FROM RpJmt r WHERE r.klkod = :klkod")
//    , @NamedQuery(name = "RpJmt.findByKpkod", query = "SELECT r FROM RpJmt r WHERE r.kpkod = :kpkod")
//    , @NamedQuery(name = "RpJmt.findByJmtgl", query = "SELECT r FROM RpJmt r WHERE r.jmtgl = :jmtgl")
//    , @NamedQuery(name = "RpJmt.findByJmhut", query = "SELECT r FROM RpJmt r WHERE r.jmhut = :jmhut")
//    , @NamedQuery(name = "RpJmt.findByJmbpt", query = "SELECT r FROM RpJmt r WHERE r.jmbpt = :jmbpt")
//    , @NamedQuery(name = "RpJmt.findByJmsid", query = "SELECT r FROM RpJmt r WHERE r.jmsid = :jmsid")
//    , @NamedQuery(name = "RpJmt.findByJmnkh", query = "SELECT r FROM RpJmt r WHERE r.jmnkh = :jmnkh")
//    , @NamedQuery(name = "RpJmt.findByJmkrj", query = "SELECT r FROM RpJmt r WHERE r.jmkrj = :jmkrj")
//    , @NamedQuery(name = "RpJmt.findByJmpdk", query = "SELECT r FROM RpJmt r WHERE r.jmpdk = :jmpdk")
//    , @NamedQuery(name = "RpJmt.findByKmkod", query = "SELECT r FROM RpJmt r WHERE r.kmkod = :kmkod")
//    , @NamedQuery(name = "RpJmt.findByJmhub", query = "SELECT r FROM RpJmt r WHERE r.jmhub = :jmhub")
//    , @NamedQuery(name = "RpJmt.findByJmjkl", query = "SELECT r FROM RpJmt r WHERE r.jmjkl = :jmjkl")})
public class RpJmt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "jmkod", nullable = false, length = 8)
    private String jmkod;
    @Size(max = 30)
    @Column(name = "jmnam", length = 30)
    private String jmnam;
    @Column(name = "jmtgl")
    @Temporal(TemporalType.DATE)
    private Date jmtgl;
    @Size(max = 5)
    @Column(name = "jmhut", length = 5)
    private String jmhut;
    @Size(max = 255)
    @Column(name = "jmbpt", length = 255)
    private String jmbpt;
    @Size(max = 255)
    @Column(name = "jmsid", length = 255)
    private String jmsid;
    @Size(max = 255)
    @Column(name = "jmnkh", length = 255)
    private String jmnkh;
    @Size(max = 255)
    @Column(name = "jmkrj", length = 255)
    private String jmkrj;
    @Size(max = 255)
    @Column(name = "jmpdk", length = 255)
    private String jmpdk;
    @Size(max = 255)
    @Column(name = "jmhub", length = 255)
    private String jmhub;
    @Size(max = 255)
    @Column(name = "jmjkl", length = 255)
    private String jmjkl;

    
    
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "id_klkod")
    @Getter @Setter
    private RmKel klkod;
    @NotNull    
    @JoinColumn(name = "id_kpkod")
    @Getter @Setter 
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    private RmKpl kpkod;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "id_kmkod")
    @Getter @Setter    
    private RmKms kmkod;    
    
    public RpJmt(){}
    
    public RpJmt(String id) {
        this.id = id;
    }

    public RpJmt(String id, String jmkod) {
        this.id = id;
        this.jmkod = jmkod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJmkod() {
        return jmkod;
    }

    public void setJmkod(String jmkod) {
        this.jmkod = jmkod;
    }

    public String getJmnam() {
        return jmnam;
    }

    public void setJmnam(String jmnam) {
        this.jmnam = jmnam;
    }

    public Date getJmtgl() {
        return jmtgl;
    }

    public void setJmtgl(Date jmtgl) {
        this.jmtgl = jmtgl;
    }

    public String getJmhut() {
        return jmhut;
    }

    public void setJmhut(String jmhut) {
        this.jmhut = jmhut;
    }

    public String getJmbpt() {
        return jmbpt;
    }

    public void setJmbpt(String jmbpt) {
        this.jmbpt = jmbpt;
    }

    public String getJmsid() {
        return jmsid;
    }

    public void setJmsid(String jmsid) {
        this.jmsid = jmsid;
    }

    public String getJmnkh() {
        return jmnkh;
    }

    public void setJmnkh(String jmnkh) {
        this.jmnkh = jmnkh;
    }

    public String getJmkrj() {
        return jmkrj;
    }

    public void setJmkrj(String jmkrj) {
        this.jmkrj = jmkrj;
    }

    public String getJmpdk() {
        return jmpdk;
    }

    public void setJmpdk(String jmpdk) {
        this.jmpdk = jmpdk;
    }

    public String getJmhub() {
        return jmhub;
    }

    public void setJmhub(String jmhub) {
        this.jmhub = jmhub;
    }

    public String getJmjkl() {
        return jmjkl;
    }

    public void setJmjkl(String jmjkl) {
        this.jmjkl = jmjkl;
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
        if (!(object instanceof RpJmt)) {
            return false;
        }
        RpJmt other = (RpJmt) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.id.sigada.entities.RpJmt[ id=" + id + " ]";
    }
    
}
