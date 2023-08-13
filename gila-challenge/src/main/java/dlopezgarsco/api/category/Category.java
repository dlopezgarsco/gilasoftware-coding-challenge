package dlopezgarsco.api.category;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class Category {
    private Integer categoryId;
    private String name;

    @JsonProperty
    public Integer getCategoryId() {
        return categoryId;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equal(categoryId, category.categoryId) && Objects.equal(name, category.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(categoryId, name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
