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
public class SlotId implements Serializable {
    private static final long serialVersionUID = 9086270097870178660L;
    @Column(name = "pos_id", nullable = false, length = Integer.MAX_VALUE)
    private String posId;

    @Column(name = "np", nullable = false)
    private Integer np;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SlotId entity = (SlotId) o;
        return Objects.equals(this.posId, entity.posId) &&
                Objects.equals(this.np, entity.np);
    }

    @Override
    public int hashCode() {
        return Objects.hash(posId, np);
    }

}