package com.anb.recipeapp.resource;

import com.anb.recipeapp.domain.Recipe;
import com.anb.recipeapp.service.RecipeService;
import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/recipe")
//@Api(value = "myController", tags = { "My Controller" })
public class RecipeController {

    Logger logger = LoggerFactory.getLogger(RecipeController.class);
    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping()
    public ResponseEntity createRecipe(@RequestBody Recipe recipe){
        Recipe savedRecipe =  recipeService.createRecipe(recipe);
        return new ResponseEntity<>("Recipe created:"+savedRecipe.getId(), HttpStatusCode.valueOf(201));
    }
    @GetMapping("/{id}")
    public ResponseEntity getRecipe(@PathVariable long id){
        logger.info(String.valueOf(id));
        Recipe recipe =  recipeService.getRecipe(id);
        return new ResponseEntity<>(recipe, HttpStatusCode.valueOf(200));
    }

    @PutMapping()
    public ResponseEntity updateRecipe(@RequestBody Recipe recipe){
        logger.info(String.valueOf(recipe.getId()));
        Recipe savedRecipe =  recipeService.updateRecipe(recipe);
        return new ResponseEntity<>("Recipe created:"+savedRecipe.getId(), HttpStatusCode.valueOf(200));
    }

    @DeleteMapping()
    public ResponseEntity deleteRecipe(@PathParam("id") Long id){
        logger.info(String.valueOf(id));
        recipeService.deleteRecipe(id);
        return new ResponseEntity<>(HttpStatusCode.valueOf(204));
    }
    @GetMapping("/search/{queryString}")
    public List<Recipe> searchProducts(@PathVariable String queryString){
        return recipeService.searchRecipe(queryString);
    }


}
