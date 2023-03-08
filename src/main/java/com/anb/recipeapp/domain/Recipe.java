package com.anb.recipeapp.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Table;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(appliesTo = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECIPE_SEQ")
    @SequenceGenerator(name="RECIPE_SEQ", sequenceName = "RECIPE_SEQ")
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String diet;
    private Integer servings;
    private String ingredient;
    private String note;

/*    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();*/
}
