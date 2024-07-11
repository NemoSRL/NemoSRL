package com.example.NemoSRL.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
@ToString
public class ReportId implements Serializable {
    private static final long serialVersionUID = -1904614981309198374L;
    @ColumnDefault("nextval('report_np_seq'::regclass)")
    @Column(name = "np", nullable = false)
    private Integer np;

    @Column(name = "etichetta", nullable = false)
    private Integer etichetta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ReportId entity = (ReportId) o;
        return Objects.equals(this.np, entity.np) &&
                Objects.equals(this.etichetta, entity.etichetta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(np, etichetta);
    }

}