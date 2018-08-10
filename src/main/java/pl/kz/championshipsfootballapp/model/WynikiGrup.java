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
@Table(name = "WYNIKI_GRUP", catalog = "kz_wc18", schema = "KZ")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WynikiGrup.findAll", query = "SELECT w FROM WynikiGrup w")
    , @NamedQuery(name = "WynikiGrup.findByPkt", query = "SELECT w FROM WynikiGrup w WHERE w.pkt = :pkt")
    , @NamedQuery(name = "WynikiGrup.findByWyg", query = "SELECT w FROM WynikiGrup w WHERE w.wyg = :wyg")
    , @NamedQuery(name = "WynikiGrup.findByRem", query = "SELECT w FROM WynikiGrup w WHERE w.rem = :rem")
    , @NamedQuery(name = "WynikiGrup.findByPor", query = "SELECT w FROM WynikiGrup w WHERE w.por = :por")
    , @NamedQuery(name = "WynikiGrup.findByStrzel", query = "SELECT w FROM WynikiGrup w WHERE w.strzel = :strzel")
    , @NamedQuery(name = "WynikiGrup.findByStrac", query = "SELECT w FROM WynikiGrup w WHERE w.strac = :strac")
    , @NamedQuery(name = "WynikiGrup.findById", query = "SELECT w FROM WynikiGrup w WHERE w.id = :id")})
public class WynikiGrup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(nullable = false)
    private int pkt;
    @Basic(optional = false)
    @Column(nullable = false)
    private int wyg;
    @Basic(optional = false)
    @Column(nullable = false)
    private int rem;
    @Basic(optional = false)
    @Column(nullable = false)
    private int por;
    @Basic(optional = false)
    @Column(nullable = false)
    private int strzel;
    @Basic(optional = false)
    @Column(nullable = false)
    private int strac;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "team_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Team teamID;

    public WynikiGrup() {
    }

    public WynikiGrup(Integer id) {
        this.id = id;
    }

    public WynikiGrup(Integer id, int pkt, int wyg, int rem, int por, int strzel, int strac) {
        this.id = id;
        this.pkt = pkt;
        this.wyg = wyg;
        this.rem = rem;
        this.por = por;
        this.strzel = strzel;
        this.strac = strac;
    }

    public int getPkt() {
        return pkt;
    }

    public void setPkt(int pkt) {
        this.pkt = pkt;
    }

    public int getWyg() {
        return wyg;
    }

    public void setWyg(int wyg) {
        this.wyg = wyg;
    }

    public int getRem() {
        return rem;
    }

    public void setRem(int rem) {
        this.rem = rem;
    }

    public int getPor() {
        return por;
    }

    public void setPor(int por) {
        this.por = por;
    }

    public int getStrzel() {
        return strzel;
    }

    public void setStrzel(int strzel) {
        this.strzel = strzel;
    }

    public int getStrac() {
        return strac;
    }

    public void setStrac(int strac) {
        this.strac = strac;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof WynikiGrup)) {
            return false;
        }
        WynikiGrup other = (WynikiGrup) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kz.championshipsfootballapp.model.WynikiGrup[ id=" + id + " ]";
    }
    
}
