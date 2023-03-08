package com.anb.recipeapp.service;

import com.anb.recipeapp.domain.Recipe;
import com.anb.recipeapp.repository.RecipeRepository;
import com.anb.recipeapp.util.QuerySentimentUtil;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository productRepository) {
        this.recipeRepository = productRepository;    }


    public Recipe getRecipe(Long id) {
        System.out.println(id);
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);

        return recipeOptional.get();
    }

    public Recipe createRecipe(Recipe recipe) {
        Recipe savedRecipe = recipeRepository.save(recipe);
        return savedRecipe;
    }

    public Recipe updateRecipe(Recipe recipe) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipe.getId());
        Recipe recipeEntity = recipeOptional.orElseThrow(EntityNotFoundException::new);
        return recipeEntity;
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }


    public List<Recipe> searchRecipe(String recipeQuery) {

        String queryId = QuerySentimentUtil.keywordFinder(recipeQuery);
        List<Recipe> recipeList = recipeRepository.searchRecipe(queryId);
        return recipeList;
    }
}
