package com.example.NemoSRL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class R9Id implements Serializable {
    private static final long serialVersionUID = -820568870321915482L;
    @Column(name = "prodotto", nullable = false)
    private Integer prodotto;

    @Column(name = "confezione", nullable = false)
    private Integer confezione;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        R9Id entity = (R9Id) o;
        return Objects.equals(this.confezione, entity.confezione) &&
                Objects.equals(this.prodotto, entity.prodotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(confezione, prodotto);
    }

}