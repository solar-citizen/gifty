package dev.pp.gifty.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "gifts")
public class Gift {

    public Gift() {}

    public Gift(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Id
    @Column(columnDefinition = "integer")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gifts_generator")
    @SequenceGenerator(name = "gifts_generator", sequenceName = "gifts_seq", allocationSize = 1)
    private Long id;

    @Column(columnDefinition = "text")
    private String name;

    @Column(columnDefinition = "text")
    private String description;

    @Transient
    @ManyToMany
    @JoinTable(name = "gift_categories",
               joinColumns = @JoinColumn(name = "gift_id"),
               inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
