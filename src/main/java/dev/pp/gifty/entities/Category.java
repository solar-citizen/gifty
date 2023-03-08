package dev.pp.gifty.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @Column(columnDefinition = "integer")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "categoriesIdSequence", sequenceName = "categories_id_seq", allocationSize = 1)
    private Long id;

    @Column(columnDefinition = "text")
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category() {

    }
}
