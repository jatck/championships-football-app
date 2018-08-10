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
    @NamedQuery(name = "Strefy.findAll", query = "SELECT s FROM Strefy s")
    , @NamedQuery(name = "Strefy.findById", query = "SELECT s FROM Strefy s WHERE s.id = :id")
    , @NamedQuery(name = "Strefy.findByNazwa", query = "SELECT s FROM Strefy s WHERE s.nazwa = :nazwa")
    , @NamedQuery(name = "Strefy.findByStrefaKod", query = "SELECT s FROM Strefy s WHERE s.strefaKod = :strefaKod")})
public class Strefy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String nazwa;
    @Basic(optional = false)
    @Column(name = "strefa_kod", nullable = false, length = 10)
    private String strefaKod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "strefyID", fetch = FetchType.LAZY)
    private List<Sedziowie> sedziowieList;
    @OneToMany(mappedBy = "strefyID", fetch = FetchType.LAZY)
    private List<Team> teamList;

    public Strefy() {
    }

    public Strefy(Integer id) {
        this.id = id;
    }

    public Strefy(Integer id, String nazwa, String strefaKod) {
        this.id = id;
        this.nazwa = nazwa;
        this.strefaKod = strefaKod;
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

    public String getStrefaKod() {
        return strefaKod;
    }

    public void setStrefaKod(String strefaKod) {
        this.strefaKod = strefaKod;
    }

    @XmlTransient
    public List<Sedziowie> getSedziowieList() {
        return sedziowieList;
    }

    public void setSedziowieList(List<Sedziowie> sedziowieList) {
        this.sedziowieList = sedziowieList;
    }

    @XmlTransient
    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
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
        if (!(object instanceof Strefy)) {
            return false;
        }
        Strefy other = (Strefy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kz.championshipsfootballapp.model.Strefy[ id=" + id + " ]";
    }
    
}
