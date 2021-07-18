package com.viettel.domain;


import com.viettel.service.dto.CategoryDTO;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * A Category.
 */
@Entity
@Table(name = "category")
@SqlResultSetMapping(
    name = "adminCategoryMapping",
    classes = {
        @ConstructorResult(
            targetClass = CategoryDTO.class,
            columns = {
                @ColumnResult(name = "id", type = Long.class),
                @ColumnResult(name = "code", type = String.class),
                @ColumnResult(name = "name", type = String.class),
                @ColumnResult(name = "des", type = String.class)
            }
        )
    }
)

public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "des")
    private String des;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public Category name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public Category des(String des) {
        this.des = des;
        return this;
    }

    public Category() {
    }

    public Category(Long id, String code, String name, String des) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.des = des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Category)) {
            return false;
        }
        return id != null && id.equals(((Category) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Category{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", des='" + getDes() + "'" +
            "}";
    }
}
