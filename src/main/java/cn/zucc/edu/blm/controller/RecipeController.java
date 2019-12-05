package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.RecipeDao;
import cn.zucc.edu.blm.bean.Recipe;
import cn.zucc.edu.blm.bean.ShopEvaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/Recipe")
public class RecipeController {
    @Autowired
    private RecipeDao recipeDao;

    @GetMapping("/getRecipeList")
    public List<Recipe> getRecipeList(@RequestParam(value = "shopId") int shopId){
        List<Recipe> lst=new ArrayList();
        lst=recipeDao.findByShopId(shopId);
        for(int i=0;i<lst.size();i++){
            lst.get(i).setRecipeImage(null);
        }
        return  lst;
    }

    @GetMapping("/getRecipeImage")
    public Recipe getRecipeImage(@RequestParam(value = "recipeId") int recipeId){
        return recipeDao.findById(recipeId).orElse(null);
    }

    @GetMapping("/getRecipe")
    public Recipe getRecipe(@RequestParam(value = "recipeId") int recipeId){

        Optional optional=recipeDao.findById(recipeId);
        return  (Recipe) optional.orElse(null);
    }

    @GetMapping("/getRecipeIdList")
    public  List<Integer> getRecipeIdList(@RequestParam(value = "shopId") int shopId){
        List<Integer> response=new ArrayList<>();
        List<Recipe> lst=recipeDao.findByShopId(shopId);
        for(Recipe a:lst){
            response.add(a.getRecipeId());
        }
        return response;
    }


}
