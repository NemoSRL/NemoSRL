package com.example.NemoSRL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PrezzointernoId implements Serializable {
    private static final long serialVersionUID = 2463883600651913282L;
    @Column(name = "datainizio", nullable = false)
    private LocalDate datainizio;

    @Column(name = "datafine", nullable = false)
    private LocalDate datafine;

    @Column(name = "prodotto", nullable = false)
    private Integer prodotto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PrezzointernoId entity = (PrezzointernoId) o;
        return Objects.equals(this.datainizio, entity.datainizio) &&
                Objects.equals(this.prodotto, entity.prodotto) &&
                Objects.equals(this.datafine, entity.datafine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datainizio, prodotto, datafine);
    }

}