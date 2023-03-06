package dev.pp.gifty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "gifts")
public class Gift {

    @Id
    @Column(columnDefinition = "integer")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "giftsIdSequence", sequenceName = "gifts_id_seq", allocationSize = 1)
    private Long id;

    @Column(columnDefinition = "text")
    private String name;

    @Transient
    private List<Category> categories;

    public Gift() {
        // Entity.
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
