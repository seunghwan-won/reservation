package seunghwan.won.dto;

import java.util.Objects;

public class CategoryJoinProduct {
    private int id;
    private String name;
    private int count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CategoryJoinProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryJoinProduct categoryJoinProduct = (CategoryJoinProduct) o;
        return id == categoryJoinProduct.id &&
                count == categoryJoinProduct.count &&
                Objects.equals(name, categoryJoinProduct.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, count);
    }
}
