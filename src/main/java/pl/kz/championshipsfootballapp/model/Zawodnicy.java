/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kz.championshipsfootballapp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JACZAW
 */
@Entity
@Table(catalog = "kz_wc18", schema = "KZ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zawodnicy.findAll", query = "SELECT z FROM Zawodnicy z")
    , @NamedQuery(name = "Zawodnicy.findById", query = "SELECT z FROM Zawodnicy z WHERE z.id = :id")
    , @NamedQuery(name = "Zawodnicy.findByNazwa", query = "SELECT z FROM Zawodnicy z WHERE z.nazwa = :nazwa")
    , @NamedQuery(name = "Zawodnicy.findByDataUrodzin", query = "SELECT z FROM Zawodnicy z WHERE z.dataUrodzin = :dataUrodzin")
    , @NamedQuery(name = "Zawodnicy.findByWzrost", query = "SELECT z FROM Zawodnicy z WHERE z.wzrost = :wzrost")})
public class Zawodnicy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 50)
    private String nazwa;
    @Column(name = "data_urodzin")
    @Temporal(TemporalType.DATE)
    private Date dataUrodzin;
    private Integer wzrost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zawodnicyID", fetch = FetchType.LAZY)
    private List<Zdarzenia> zdarzeniaList;
    @JoinColumn(name = "kluby_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Kluby klubyID;
    @JoinColumn(name = "pozycje_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pozycje pozycjeID;
    @JoinColumn(name = "team_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Team teamID;

    public Zawodnicy() {
    }

    public Zawodnicy(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Date getDataUrodzin() {
        return dataUrodzin;
    }

    public void setDataUrodzin(Date dataUrodzin) {
        this.dataUrodzin = dataUrodzin;
    }

    public Integer getWzrost() {
        return wzrost;
    }

    public void setWzrost(Integer wzrost) {
        this.wzrost = wzrost;
    }

    @XmlTransient
    public List<Zdarzenia> getZdarzeniaList() {
        return zdarzeniaList;
    }

    public void setZdarzeniaList(List<Zdarzenia> zdarzeniaList) {
        this.zdarzeniaList = zdarzeniaList;
    }

    public Kluby getKlubyID() {
        return klubyID;
    }

    public void setKlubyID(Kluby klubyID) {
        this.klubyID = klubyID;
    }

    public Pozycje getPozycjeID() {
        return pozycjeID;
    }

    public void setPozycjeID(Pozycje pozycjeID) {
        this.pozycjeID = pozycjeID;
    }

    public Team getTeamID() {
        return teamID;
    }

    public void setTeamID(Team teamID) {
        this.teamID = teamID;
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
        if (!(object instanceof Zawodnicy)) {
            return false;
        }
        Zawodnicy other = (Zawodnicy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kz.championshipsfootballapp.model.Zawodnicy[ id=" + id + " ]";
    }
    
}
