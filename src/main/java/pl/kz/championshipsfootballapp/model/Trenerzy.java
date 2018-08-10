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
    @NamedQuery(name = "Trenerzy.findAll", query = "SELECT t FROM Trenerzy t")
    , @NamedQuery(name = "Trenerzy.findById", query = "SELECT t FROM Trenerzy t WHERE t.id = :id")
    , @NamedQuery(name = "Trenerzy.findByNazwa", query = "SELECT t FROM Trenerzy t WHERE t.nazwa = :nazwa")})
public class Trenerzy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(length = 50)
    private String nazwa;
    @JoinColumn(name = "kraje_ID", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Kraje krajeID;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trenerzyID", fetch = FetchType.LAZY)
    private List<Team> teamList;

    public Trenerzy() {
    }

    public Trenerzy(Integer id) {
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

    public Kraje getKrajeID() {
        return krajeID;
    }

    public void setKrajeID(Kraje krajeID) {
        this.krajeID = krajeID;
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
        if (!(object instanceof Trenerzy)) {
            return false;
        }
        Trenerzy other = (Trenerzy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.kz.championshipsfootballapp.model.Trenerzy[ id=" + id + " ]";
    }
    
}
