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
    @NamedQuery(name = "Mecze.findAll", query = "SELECT m FROM Mecze m")
    , @NamedQuery(name = "Mecze.findById", query = "SELECT m FROM Mecze m WHERE m.id = :id")
    , @NamedQuery(name = "Mecze.findByNazwa", query = "SELECT m FROM Mecze m WHERE m.nazwa = :nazwa")
    , @NamedQuery(name = "Mecze.findByData", query = "SELECT m FROM Mecze m WHERE m.data = :data")
    , @NamedQuery(name = "Mecze.findByGodzina", query = "SELECT m FROM Mecze m WHERE m.godzina = :godzina")})
public class Mecze implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 50)
    private String nazwa;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date data;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIME)
    private Date godzina;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meczeID", fetch = FetchType.LAZY)
    private List<Rozgrywki> rozgrywkiList;
    @JoinColumn(name = "grupy_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Grupy grupyID;
    @JoinColumn(name = "sedziowie_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Sedziowie sedziowieID;
    @JoinColumn(name = "stadiony_ID", referencedColumnName = "ID", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Stadiony stadionyID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meczeID", fetch = FetchType.LAZY)
    private List<Zdarzenia> zdarzeniaList;

    public Mecze() {
    }

    public Mecze(Integer id) {
        this.id = id;
    }

    public Mecze(Integer id, Date data, Date godzina) {
        this.id = id;
        this.data = data;
        this.godzina = godzina;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getGodzina() {
        return godzina;
    }

    public void setGodzina(Date godzina) {
        this.godzina = godzina;
    }

    @XmlTransient
    public List<Rozgrywki> getRozgrywkiList() {
        return rozgrywkiList;
    }

    public void setRozgrywkiList(List<Rozgrywki> rozgrywkiList) {
        this.rozgrywkiList = rozgrywkiList;
    }

    public Grupy getGrupyID() {
        return grupyID;
    }

    public void setGrupyID(Grupy grupyID) {
        this.grupyID = grupyID;
    }

    public Sedziowie getSedziowieID() {
        return sedziowieID;
    }

    public void setSedziowieID(Sedziowie sedziowieID) {
        this.sedziowieID = sedziowieID;
    }

    public Stadiony getStadionyID() {
        return stadionyID;
    }

    public void setStadionyID(Stadiony stadionyID) {
        this.stadionyID = stadionyID;
    }

    @XmlTransient
    public List<Zdarzenia> getZdarzeniaList() {
        return zdarzeniaList;
    }

    public void setZdarzeniaList(List<Zdarzenia> zdarzeniaList) {
        this.zdarzeniaList = zdarzeniaList;
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
        if (!(object instanceof Mecze)) {
            return false;
        }
        Mecze other = (Mecze) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kz.championshipsfootballapp.model.Mecze[ id=" + id + " ]";
    }
    
}
