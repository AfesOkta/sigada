/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.id.sigada.entities;

import com.id.sigada.constants.StatusBaptis;
import com.id.sigada.constants.StatusHubKk;
import com.id.sigada.constants.StatusJenisKelamin;
import com.id.sigada.constants.StatusNikah;
import com.id.sigada.constants.StatusPekerjaan;
import com.id.sigada.constants.StatusPendidikan;
import com.id.sigada.constants.StatusSidi;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    @Column(name = "jmbpt")
    @Enumerated(EnumType.STRING)
    StatusBaptis statusBaptis;
    @Column(name = "jmsid")
    @Enumerated(EnumType.STRING)
    StatusSidi statusSidi;
    @Column(name = "jmnkh")
    @Enumerated(EnumType.STRING)
    StatusNikah statusNikah;
    @Column(name = "jmkrj")
    @Enumerated(EnumType.STRING)
    StatusPekerjaan statusPekerjaan;
    @Column(name = "jmpdk")
    @Enumerated(EnumType.STRING)
    StatusPendidikan statusPendidikan;
    @Column(name = "jmhub")
    @Enumerated(EnumType.STRING)
    StatusHubKk statusHubKk;
    @Column(name = "jmjkl")
    @Enumerated(EnumType.STRING)
    StatusJenisKelamin sjk;
    
    
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
    
  
    
}
