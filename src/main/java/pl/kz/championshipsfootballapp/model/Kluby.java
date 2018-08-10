package pl.kz.championshipsfootballapp.model;

/*
  Created by JACZAW on 29.05.2018.
 */
import java.awt.*;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * To create ID generator sequence "kluby_ID_SEQ_GEN":
 * CREATE SEQUENCE "kluby_ID_SEQ_GEN" INCREMENT BY 50 START WITH 50;
 */
@Entity
@NamedQueries({ @NamedQuery(name = "Kluby.findAll", query = "select o from Kluby o") })

public class Kluby implements Serializable {
    private static final long serialVersionUID = -5749079754615543672L;



    @Id
    @Column(nullable = false)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Kluby_Id_Seq_Gen")
    private Long id;
    @Column(nullable = false)
    private String nazwa;

    public Kluby() {
    }

    public Kluby(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("id=");
        buffer.append(getId());
        buffer.append(',');
        buffer.append("nazwa=");
        buffer.append(getNazwa());
        buffer.append(']');
        return buffer.toString();
    }
}
