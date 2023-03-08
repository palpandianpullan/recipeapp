package com.anb.recipeapp.repository;

import com.anb.recipeapp.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    @Query("SELECT r FROM Recipe r WHERE " +
            "r.name LIKE CONCAT('%',:query, '%')" +
            "Or r.diet LIKE CONCAT('%', :query, '%')"+
            "Or r.ingredient LIKE CONCAT('%', :query, '%')"+
            "Or r.note LIKE CONCAT('%', :query, '%')")
    List<Recipe> searchRecipe(String query);

}
