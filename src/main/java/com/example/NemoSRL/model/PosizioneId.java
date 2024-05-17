package com.example.NemoSRL.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PosizioneId implements Serializable {
    private static final long serialVersionUID = -3409521670328153133L;
    @ColumnDefault("nextval('posizione_id_seq'::regclass)")
    @Column(name = "id", nullable = false)

    private String id;

    @ColumnDefault("nextval('posizione_np_seq'::regclass)")
    @Column(name = "np", nullable = false)
    private Integer np;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PosizioneId entity = (PosizioneId) o;
        return Objects.equals(this.np, entity.np) &&
                Objects.equals(this.id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(np, id);
    }

}