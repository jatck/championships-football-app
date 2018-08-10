/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kz.championshipsfootballapp.model;

import java.io.Serializable;
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
    @NamedQuery(name = "Sedziowie.findAll", query = "SELECT s FROM Sedziowie s")
    , @NamedQuery(name = "Sedziowie.findById", query = "SELECT s FROM Sedziowie s WHERE s.id = :id")
    , @NamedQuery(name = "Sedziowie.findByNazwa", query = "SELECT s FROM Sedziowie s WHERE s.nazwa = :nazwa")})
public class Sedziowie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String nazwa;
    @JoinColumn(name = "kraje_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Kraje krajeID;
    @JoinColumn(name = "strefy_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Strefy strefyID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sedziowieID", fetch = FetchType.LAZY)
    private List<Mecze> meczeList;

    public Sedziowie() {
    }

    public Sedziowie(Integer id) {
        this.id = id;
    }

    public Sedziowie(Integer id, String nazwa) {
        this.id = id;
        this.nazwa = nazwa;
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

    public Kraje getKrajeID() {
        return krajeID;
    }

    public void setKrajeID(Kraje krajeID) {
        this.krajeID = krajeID;
    }

    public Strefy getStrefyID() {
        return strefyID;
    }

    public void setStrefyID(Strefy strefyID) {
        this.strefyID = strefyID;
    }

    @XmlTransient
    public List<Mecze> getMeczeList() {
        return meczeList;
    }

    public void setMeczeList(List<Mecze> meczeList) {
        this.meczeList = meczeList;
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
        if (!(object instanceof Sedziowie)) {
            return false;
        }
        Sedziowie other = (Sedziowie) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kz.championshipsfootballapp.model.Sedziowie[ id=" + id + " ]";
    }
    
}
