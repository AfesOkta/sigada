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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "rpjmt")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RpJmt.findAll", query = "SELECT r FROM RpJmt r")
    , @NamedQuery(name = "RpJmt.findByJmkod", query = "SELECT r FROM RpJmt r WHERE r.jmkod = :jmkod")
    , @NamedQuery(name = "RpJmt.findByJmnam", query = "SELECT r FROM RpJmt r WHERE r.jmnam = :jmnam")
    , @NamedQuery(name = "RpJmt.findByKlkod", query = "SELECT r FROM RpJmt r WHERE r.klkod = :klkod")
    , @NamedQuery(name = "RpJmt.findByKpkod", query = "SELECT r FROM RpJmt r WHERE r.kpkod = :kpkod")
    , @NamedQuery(name = "RpJmt.findByJmtgl", query = "SELECT r FROM RpJmt r WHERE r.jmtgl = :jmtgl")
    , @NamedQuery(name = "RpJmt.findByJmhut", query = "SELECT r FROM RpJmt r WHERE r.jmhut = :jmhut")
    , @NamedQuery(name = "RpJmt.findByJmbpt", query = "SELECT r FROM RpJmt r WHERE r.jmbpt = :jmbpt")
    , @NamedQuery(name = "RpJmt.findByJmsid", query = "SELECT r FROM RpJmt r WHERE r.jmsid = :jmsid")
    , @NamedQuery(name = "RpJmt.findByJmnkh", query = "SELECT r FROM RpJmt r WHERE r.jmnkh = :jmnkh")
    , @NamedQuery(name = "RpJmt.findByJmkrj", query = "SELECT r FROM RpJmt r WHERE r.jmkrj = :jmkrj")
    , @NamedQuery(name = "RpJmt.findByJmpdk", query = "SELECT r FROM RpJmt r WHERE r.jmpdk = :jmpdk")
    , @NamedQuery(name = "RpJmt.findByKmkod", query = "SELECT r FROM RpJmt r WHERE r.kmkod = :kmkod")
    , @NamedQuery(name = "RpJmt.findByJmhub", query = "SELECT r FROM RpJmt r WHERE r.jmhub = :jmhub")
    , @NamedQuery(name = "RpJmt.findByJmjkl", query = "SELECT r FROM RpJmt r WHERE r.jmjkl = :jmjkl")})
public class RpJmt implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "uuid" )
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "jmkod")
    private String jmkod;
    @Size(max = 30)
    @Column(name = "jmnam")
    private String jmnam;
    @Size(max = 4)
    @Column(name = "klkod")
    private String klkod;
    @Size(max = 2)
    @Column(name = "kpkod")
    private String kpkod;
    @Column(name = "jmtgl")
    @Temporal(TemporalType.DATE)
    private Date jmtgl;
    @Size(max = 5)
    @Column(name = "jmhut")
    private String jmhut;
    @Column(name = "jmbpt")
    private Boolean jmbpt;
    @Column(name = "jmsid")
    private Boolean jmsid;
    @Column(name = "jmnkh")
    private Character jmnkh;
    @Column(name = "jmkrj")
    private Character jmkrj;
    @Column(name = "jmpdk")
    private Character jmpdk;
    @Column(name = "kmkod")
    private Character kmkod;
    @Column(name = "jmhub")
    private Character jmhub;
    @Column(name = "jmjkl")
    private Character jmjkl;
    
}
