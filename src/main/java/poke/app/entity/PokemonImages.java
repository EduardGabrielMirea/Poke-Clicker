package poke.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PokemonImages {
    @Id
    Long order;
    String name;

    public PokemonImages(Long order, String name) {
        this.order = order;
        this.name = name;
    }

    public PokemonImages(String name) {
        this.name = name;
    }

    public PokemonImages() {
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PokemonImages{" +
                "order=" + order +
                ", name='" + name + '\'' +
                '}';
    }
}
