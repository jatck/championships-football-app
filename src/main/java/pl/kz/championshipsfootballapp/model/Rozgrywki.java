/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kz.championshipsfootballapp.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JACZAW
 */
@Entity
@Table(catalog = "kz_wc18", schema = "KZ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rozgrywki.findAll", query = "SELECT r FROM Rozgrywki r")
    , @NamedQuery(name = "Rozgrywki.findById", query = "SELECT r FROM Rozgrywki r WHERE r.id = :id")
    , @NamedQuery(name = "Rozgrywki.findByBramki", query = "SELECT r FROM Rozgrywki r WHERE r.bramki = :bramki")
    , @NamedQuery(name = "Rozgrywki.findByKartkiZol", query = "SELECT r FROM Rozgrywki r WHERE r.kartkiZol = :kartkiZol")
    , @NamedQuery(name = "Rozgrywki.findByKartkiCzer", query = "SELECT r FROM Rozgrywki r WHERE r.kartkiCzer = :kartkiCzer")})
public class Rozgrywki implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    private Integer bramki;
    @Column(name = "kartki_zol")
    private Integer kartkiZol;
    @Column(name = "kartki_czer")
    private Integer kartkiCzer;
    @JoinColumn(name = "mecze_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mecze meczeID;
    @JoinColumn(name = "team_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Team teamID;

    public Rozgrywki() {
    }

    public Rozgrywki(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBramki() {
        return bramki;
    }

    public void setBramki(Integer bramki) {
        this.bramki = bramki;
    }

    public Integer getKartkiZol() {
        return kartkiZol;
    }

    public void setKartkiZol(Integer kartkiZol) {
        this.kartkiZol = kartkiZol;
    }

    public Integer getKartkiCzer() {
        return kartkiCzer;
    }

    public void setKartkiCzer(Integer kartkiCzer) {
        this.kartkiCzer = kartkiCzer;
    }

    public Mecze getMeczeID() {
        return meczeID;
    }

    public void setMeczeID(Mecze meczeID) {
        this.meczeID = meczeID;
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
        if (!(object instanceof Rozgrywki)) {
            return false;
        }
        Rozgrywki other = (Rozgrywki) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kz.championshipsfootballapp.model.Rozgrywki[ id=" + id + " ]";
    }
    
}
