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
    @NamedQuery(name = "Stadiony.findAll", query = "SELECT s FROM Stadiony s")
    , @NamedQuery(name = "Stadiony.findById", query = "SELECT s FROM Stadiony s WHERE s.id = :id")
    , @NamedQuery(name = "Stadiony.findByNazwa", query = "SELECT s FROM Stadiony s WHERE s.nazwa = :nazwa")
    , @NamedQuery(name = "Stadiony.findByPojemnosc", query = "SELECT s FROM Stadiony s WHERE s.pojemnosc = :pojemnosc")
    , @NamedQuery(name = "Stadiony.findByMiasto", query = "SELECT s FROM Stadiony s WHERE s.miasto = :miasto")})
public class Stadiony implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 40)
    private String nazwa;
    @Basic(optional = false)
    @Column(nullable = false)
    private int pojemnosc;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String miasto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stadionyID", fetch = FetchType.LAZY)
    private List<Mecze> meczeList;

    public Stadiony() {
    }

    public Stadiony(Integer id) {
        this.id = id;
    }

    public Stadiony(Integer id, String nazwa, int pojemnosc, String miasto) {
        this.id = id;
        this.nazwa = nazwa;
        this.pojemnosc = pojemnosc;
        this.miasto = miasto;
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

    public int getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(int pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
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
        if (!(object instanceof Stadiony)) {
            return false;
        }
        Stadiony other = (Stadiony) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kz.championshipsfootballapp.model.Stadiony[ id=" + id + " ]";
    }
    
}
