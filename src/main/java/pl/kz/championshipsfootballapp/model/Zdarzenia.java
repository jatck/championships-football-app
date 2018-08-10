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
    @NamedQuery(name = "Zdarzenia.findAll", query = "SELECT z FROM Zdarzenia z")
    , @NamedQuery(name = "Zdarzenia.findByMinuta", query = "SELECT z FROM Zdarzenia z WHERE z.minuta = :minuta")
    , @NamedQuery(name = "Zdarzenia.findById", query = "SELECT z FROM Zdarzenia z WHERE z.id = :id")})
public class Zdarzenia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(nullable = false)
    private int minuta;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @JoinColumn(name = "mecze_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Mecze meczeID;
    @JoinColumn(name = "sytuacje_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sytuacje sytuacjeID;
    @JoinColumn(name = "zawodnicy_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Zawodnicy zawodnicyID;

    public Zdarzenia() {
    }

    public Zdarzenia(Integer id) {
        this.id = id;
    }

    public Zdarzenia(Integer id, int minuta) {
        this.id = id;
        this.minuta = minuta;
    }

    public int getMinuta() {
        return minuta;
    }

    public void setMinuta(int minuta) {
        this.minuta = minuta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mecze getMeczeID() {
        return meczeID;
    }

    public void setMeczeID(Mecze meczeID) {
        this.meczeID = meczeID;
    }

    public Sytuacje getSytuacjeID() {
        return sytuacjeID;
    }

    public void setSytuacjeID(Sytuacje sytuacjeID) {
        this.sytuacjeID = sytuacjeID;
    }

    public Zawodnicy getZawodnicyID() {
        return zawodnicyID;
    }

    public void setZawodnicyID(Zawodnicy zawodnicyID) {
        this.zawodnicyID = zawodnicyID;
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
        if (!(object instanceof Zdarzenia)) {
            return false;
        }
        Zdarzenia other = (Zdarzenia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kz.championshipsfootballapp.model.Zdarzenia[ id=" + id + " ]";
    }
    
}
