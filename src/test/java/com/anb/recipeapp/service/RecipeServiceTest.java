package com.anb.recipeapp.service;

import com.anb.recipeapp.domain.Recipe;
import com.anb.recipeapp.repository.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {

    @Mock
    RecipeRepository recipeRepository;

    @InjectMocks RecipeService recipeService;



    @Test
    void getRecipe() {
        Recipe recipe = new Recipe(1L,"sambar","incr",5,"testval","noteval");
        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));
        Recipe assertRecipe = recipeService.getRecipe(1L);
        Assertions.assertEquals(1L,assertRecipe.getId());
        Assertions.assertEquals("sambar",assertRecipe.getName());
    }

    @Test
    void createRecipe() {
        Recipe recipe = new Recipe(1L,"pasta","incr",5,"testval","noteval");
        when(recipeRepository.save(any(Recipe.class))).thenReturn(new Recipe(1L,"sambar","incr",5,"testval","noteval"));
        Recipe assertRecipe = recipeService.createRecipe(recipe);
        Assertions.assertEquals(1L,assertRecipe.getId());
        Assertions.assertEquals("sambar",assertRecipe.getName());
    }

    @Test
    void deleteRecipe() {
        RecipeService recipeService = mock(RecipeService.class);
        recipeService.deleteRecipe(1L);
        verify(recipeService, times(1)).deleteRecipe(1L);
    }

    @Test
    void updateRecipe() {
        Recipe recipe = new Recipe(1L,"sambar","incr",5,"testval","noteval");
        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(new Recipe(1L, "pasta", "incr", 5, "testval", "noteval")));
        Recipe assertRecipe = recipeService.updateRecipe(recipe);
        Assertions.assertEquals(1L,assertRecipe.getId());
        Assertions.assertEquals("pasta",assertRecipe.getName());
    }
}