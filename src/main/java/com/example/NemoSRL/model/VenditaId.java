package com.example.NemoSRL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class VenditaId implements Serializable {
    private static final long serialVersionUID = -1198846646790834698L;
    @ColumnDefault("nextval('vendita_np_seq'::regclass)")
    @Column(name = "np", nullable = false)
    private Integer np;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        VenditaId entity = (VenditaId) o;
        return Objects.equals(this.np, entity.np) &&
                Objects.equals(this.data, entity.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(np, data);
    }

}