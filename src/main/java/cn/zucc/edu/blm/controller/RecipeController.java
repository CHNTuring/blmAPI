package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.RecipeDao;
import cn.zucc.edu.blm.Dao.ShopDao;
import cn.zucc.edu.blm.bean.Recipe;
import cn.zucc.edu.blm.bean.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/Recipe")
public class RecipeController {
    @Autowired
    private RecipeDao recipeDao;
    @Autowired
    private ShopDao shopDao;

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

    @PostMapping("/addRecipe")
    public String addRecipe(@RequestParam(value = "shopId") Integer shopId, @RequestParam(value = "recipeName") String recipeName,
                            @RequestParam(value = "recipePrice") String recipePrice, @RequestParam(value = "recipeRemain") String recipeRemain,
                            @RequestParam(value = "recipeDiscount") String recipeDiscount,@RequestParam(value = "recipeNotice") String recipeNotice
                            /*@RequestParam(value = "recipeImage") MultipartFile recipeImage*/){
        Optional<Shop> shopOptional = shopDao.findById(shopId);
        if (shopOptional.isPresent()) {
            Double doublePrice = null;
            Integer intRemain = null;
            Double doubleDiscount = null;

            try {
                doublePrice = Double.valueOf(recipePrice);
                intRemain = Integer.valueOf(recipeRemain);
                doubleDiscount = Double.valueOf(recipeDiscount);
            } catch (NumberFormatException | NullPointerException e) {
                return ErrorsHandle.ADDRECIPE_FAILED;
            }
            Recipe recipe=new Recipe();
            recipe.setMonthlySale(0);
            recipe.setRecipeDiscount(doubleDiscount);
            /*try {
                recipe.setRecipeImage(new byte[recipeImage.getInputStream().available()]);
            } catch (IOException e) {
                return ErrorsHandle.UPLOADIMAGE_FAILED;
            }*/

            recipe.setRecipeName(recipeName);
            recipe.setRecipePrice(doublePrice);
            recipe.setRecipeRemain(intRemain);
            recipe.setShopId(shopId);
            recipe.setRecipeStatus("正常");
            recipe.setRecipeNotice(recipeNotice);
            recipeDao.save(recipe);
        }
        return ErrorsHandle.SUCCESS;
    }
}
