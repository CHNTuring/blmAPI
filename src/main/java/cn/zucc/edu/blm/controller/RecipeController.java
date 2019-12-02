package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.RecipeDao;
import cn.zucc.edu.blm.bean.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Recipe")
public class RecipeController {
    @Autowired
    private RecipeDao recipeDao;

    @GetMapping("/getRecipeList")
    public List<Recipe> getRecipeList(@RequestParam(value = "shopId") int shopId){
        List lst=new ArrayList();
        lst=recipeDao.findByShopId(shopId);
        return  lst;
    }

    @GetMapping("/getRecipe")
    public Recipe getRecipe(@RequestParam(value = "recipeId") int recipeId){

        Optional optional=recipeDao.findById(recipeId);
        return  (Recipe) optional.orElse(null);
    }
}
