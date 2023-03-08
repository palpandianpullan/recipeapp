package com.anb.recipeapp.resource;

import com.anb.recipeapp.domain.Recipe;
import com.anb.recipeapp.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class RecipeControllerTest {


    @Mock
    RecipeService recipeService;
    @InjectMocks
    RecipeController recipeController;

    @BeforeEach
    public void initMocksForInjection() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createRecipe() {
        Recipe recipe  = new Recipe();
        recipe.setId(1L);
        recipe.setName("Recipe1");
        ResponseEntity responseEntity=new ResponseEntity(HttpStatus.CREATED);
        when(recipeService.createRecipe(any(Recipe.class))).thenReturn(new Recipe(1L,"test","incr",5,"testval","noteval"));
        ResponseEntity ActualResponseEntity = recipeController.createRecipe(recipe);
        assertEquals(responseEntity.getStatusCode(),ActualResponseEntity.getStatusCode());
    }

    @Test
    void updateRecipe() {
        Recipe recipe  = new Recipe();
        recipe.setId(1L);
        recipe.setName("Recipe2");
        ResponseEntity responseEntity=new ResponseEntity(HttpStatus.OK);
        when(recipeService.updateRecipe(any(Recipe.class))).thenReturn(new Recipe(1L,"test","incr",5,"testval","noteval"));
        ResponseEntity ActualResponseEntity = recipeController.updateRecipe(recipe);
        assertEquals(responseEntity.getStatusCode(),ActualResponseEntity.getStatusCode());
    }

    @Test
    void deleteRecipe() {

        ResponseEntity expectedResponseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
        ResponseEntity ActualResponseEntity = recipeController.deleteRecipe(1L);
        assertEquals(expectedResponseEntity.getStatusCode(),ActualResponseEntity.getStatusCode());
    }

    @Test
    void getRecipe() {
        Recipe recipe  = new Recipe();
        recipe.setId(1L);
        recipe.setName("Recipe1");
        ResponseEntity responseEntity=new ResponseEntity(HttpStatus.OK);
        when(recipeService.getRecipe(anyLong())).thenReturn(new Recipe(1L,"test","incr",5,"testval","noteval"));
        ResponseEntity ActualResponseEntity = recipeController.getRecipe(1L);
        assertEquals(responseEntity.getStatusCode(),ActualResponseEntity.getStatusCode());
    }

}