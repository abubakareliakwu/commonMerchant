package com.commonMerchant.domain;

import lombok.Data;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Table(name = "MerchantType")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Data
public class MerchantType {

    private static final long serialVersionUID = 4060660176973916456L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", length = 64, nullable = false, unique = true)
    private String name;

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MerchantType)) {
            return false;
        }
        return id != null && id.equals(((MerchantType) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MerchantType.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name=" + name)
                .toString();
    }
}
