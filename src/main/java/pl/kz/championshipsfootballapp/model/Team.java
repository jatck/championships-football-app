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
    @NamedQuery(name = "Team.findAll", query = "SELECT t FROM Team t")
    , @NamedQuery(name = "Team.findById", query = "SELECT t FROM Team t WHERE t.id = :id")
    , @NamedQuery(name = "Team.findByNazwa", query = "SELECT t FROM Team t WHERE t.nazwa = :nazwa")})
public class Team implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String nazwa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamID", fetch = FetchType.LAZY)
    private List<Rozgrywki> rozgrywkiList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamID", fetch = FetchType.LAZY)
    private List<WynikiGrup> wynikiGrupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teamID", fetch = FetchType.LAZY)
    private List<WynikiPuch> wynikiPuchList;
    @JoinColumn(name = "grupy_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Grupy grupyID;
    @JoinColumn(name = "strefy_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Strefy strefyID;
    @JoinColumn(name = "trenerzy_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Trenerzy trenerzyID;
    @OneToMany(mappedBy = "teamID", fetch = FetchType.LAZY)
    private List<Zawodnicy> zawodnicyList;

    public Team() {
    }

    public Team(Integer id) {
        this.id = id;
    }

    public Team(Integer id, String nazwa) {
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

    @XmlTransient
    public List<Rozgrywki> getRozgrywkiList() {
        return rozgrywkiList;
    }

    public void setRozgrywkiList(List<Rozgrywki> rozgrywkiList) {
        this.rozgrywkiList = rozgrywkiList;
    }

    @XmlTransient
    public List<WynikiGrup> getWynikiGrupList() {
        return wynikiGrupList;
    }

    public void setWynikiGrupList(List<WynikiGrup> wynikiGrupList) {
        this.wynikiGrupList = wynikiGrupList;
    }

    @XmlTransient
    public List<WynikiPuch> getWynikiPuchList() {
        return wynikiPuchList;
    }

    public void setWynikiPuchList(List<WynikiPuch> wynikiPuchList) {
        this.wynikiPuchList = wynikiPuchList;
    }

    public Grupy getGrupyID() {
        return grupyID;
    }

    public void setGrupyID(Grupy grupyID) {
        this.grupyID = grupyID;
    }

    public Strefy getStrefyID() {
        return strefyID;
    }

    public void setStrefyID(Strefy strefyID) {
        this.strefyID = strefyID;
    }

    public Trenerzy getTrenerzyID() {
        return trenerzyID;
    }

    public void setTrenerzyID(Trenerzy trenerzyID) {
        this.trenerzyID = trenerzyID;
    }

    @XmlTransient
    public List<Zawodnicy> getZawodnicyList() {
        return zawodnicyList;
    }

    public void setZawodnicyList(List<Zawodnicy> zawodnicyList) {
        this.zawodnicyList = zawodnicyList;
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
        if (!(object instanceof Team)) {
            return false;
        }
        Team other = (Team) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kz.championshipsfootballapp.model.Team[ id=" + id + " ]";
    }
    
}
