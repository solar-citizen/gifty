package dev.pp.gifty.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {

    public Category() {

    }

    @Id
    @Column(columnDefinition = "integer")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_generator")
    @SequenceGenerator(name = "categories_generator", sequenceName = "categories_seq", allocationSize = 1)
    private Long id;

    @Column(columnDefinition = "text")
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Transient
    @ManyToMany
    @JoinTable(name = "gift_categories",
               joinColumns = @JoinColumn(name = "category_id"),
               inverseJoinColumns = @JoinColumn(name = "gift_id"))
    private List<Gift> gifts;

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
