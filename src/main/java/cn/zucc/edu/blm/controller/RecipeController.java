package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.RecipeDao;
import cn.zucc.edu.blm.Dao.ShopDao;
import cn.zucc.edu.blm.bean.Recipe;
import cn.zucc.edu.blm.bean.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
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

    @GetMapping("/getAllRecipeList")
    public List<Recipe> getAllRecipeList(@RequestParam(value = "shopId") int shopId) {
        List lst = recipeDao.findByShopIdAndRecipeStatus(shopId, "正常");
        return lst;
    }

    @GetMapping("/getRecipeList")
    public List<Recipe> getRecipeList(@RequestParam(value = "shopId") int shopId) {
        List<Recipe> lst = new ArrayList();
        lst = recipeDao.findByShopIdAndRecipeStatus(shopId, "正常");
        for (int i = 0; i < lst.size(); i++) {
            lst.get(i).setRecipeImage(null);
        }
        return lst;
    }

    @GetMapping("/getRecipeImage")
    public Recipe getRecipeImage(@RequestParam(value = "recipeId") int recipeId) {
        return recipeDao.findById(recipeId).orElse(null);
    }

    @GetMapping("/getRecipe")
    public Recipe getRecipe(@RequestParam(value = "recipeId") int recipeId) {

        Optional optional = recipeDao.findById(recipeId);
        return (Recipe) optional.orElse(null);
    }

    @GetMapping("/getRecipeIdList")
    public List<Integer> getRecipeIdList(@RequestParam(value = "shopId") int shopId) {
        List<Integer> response = new ArrayList<>();
        List<Recipe> lst = recipeDao.findByShopId(shopId);
        for (Recipe a : lst) {
            response.add(a.getRecipeId());
        }
        return response;
    }

    @PostMapping("/addRecipe")
    public Recipe addRecipe(HttpServletRequest request) {
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("recipe_image");
        MultipartFile recipeImage = null;
        if (files.size() != 0)
            recipeImage = files.get(0);
        int shopId = Integer.valueOf(params.getParameter("shopId"));
        String recipeName = params.getParameter("recipe_name");
        String recipePrice = params.getParameter("recipe_price");
        String recipeRemain = params.getParameter("recipe_remain");
        String recipeDiscount = params.getParameter("recipe_discount");
        String recipeNotice = params.getParameter("recipe_notice");
        Optional<Shop> shopOptional = shopDao.findById(shopId);
        if (shopOptional.isPresent()) {
            Double doublePrice = null;
            Integer intRemain = null;
            Double doubleDiscount = null;

            try {
                doublePrice = Double.valueOf(recipePrice.trim());
                intRemain = Integer.valueOf(recipeRemain.trim());
                doubleDiscount = Double.valueOf(recipeDiscount.trim());
            } catch (NumberFormatException | NullPointerException e) {
                return null;
            }
            Recipe recipe = new Recipe();
            recipe.setMonthlySale(0);
            recipe.setRecipeDiscount(doubleDiscount);
            try {
                if (recipeImage != null && recipeImage.getInputStream().available() != 0) {
                    byte[] byteArray = new byte[recipeImage.getInputStream().available()];
                    recipeImage.getInputStream().read(byteArray);
                    recipe.setRecipeImage(byteArray);
                }
            } catch (IOException e) {
                return null;
            }

            recipe.setRecipeName(recipeName);
            recipe.setRecipePrice(doublePrice);
            recipe.setRecipeRemain(intRemain);
            recipe.setShopId(shopId);
            recipe.setRecipeStatus("正常");
            recipe.setRecipeNotice(recipeNotice);
            return recipeDao.save(recipe);
        }
        return null;
    }

    @GetMapping("/deleteRecipe")
    public String delete(@RequestParam(value = "recipeId") int recipeId) {
        Optional<Recipe> optional = recipeDao.findById(recipeId);
        if (optional.isPresent()) {
            Recipe recipe = optional.get();
            recipe.setRecipeStatus("删除");
            recipeDao.save(recipe);
            return ErrorsHandle.SUCCESS;
        }
        return ErrorsHandle.DELRECIPE_FAILED;
    }

    @PostMapping("/modifyRecipe")
    public String modifyRecipe(HttpServletRequest request) {
        MultipartHttpServletRequest params = (MultipartHttpServletRequest) request;
        List<MultipartFile> files = params.getFiles("recipe_image");
        MultipartFile recipeImage = null;
        if (files.size() != 0)
            recipeImage = files.get(0);
        int recipeId = Integer.valueOf(params.getParameter("recipeId"));
        String recipeName = params.getParameter("recipe_name");
        String recipePrice = params.getParameter("recipe_price");
        String recipeRemain = params.getParameter("recipe_remain");
        String recipeDiscount = params.getParameter("recipe_discount");
        String recipeNotice = params.getParameter("recipe_notice");
        Optional<Recipe> optionalRecipe = recipeDao.findById(recipeId);
        if (optionalRecipe.isPresent()) {
            Double doublePrice = null;
            Integer intRemain = null;
            Double doubleDiscount = null;

            try {
                doublePrice = Double.valueOf(recipePrice.trim());
                intRemain = Integer.valueOf(recipeRemain.trim());
                doubleDiscount = Double.valueOf(recipeDiscount.trim());
            } catch (NumberFormatException | NullPointerException e) {
                return ErrorsHandle.ADDRECIPE_FAILED;
            }
            Recipe recipe = optionalRecipe.get();
            recipe.setRecipeDiscount(doubleDiscount);
            try {
                if (recipeImage != null && recipeImage.getInputStream().available() != 0) {
                    byte[] byteArray = new byte[recipeImage.getInputStream().available()];
                    recipeImage.getInputStream().read(byteArray);
                    recipe.setRecipeImage(byteArray);
                }
            } catch (IOException e) {
                return ErrorsHandle.UPLOADIMAGE_FAILED;
            }

            recipe.setRecipeName(recipeName);
            recipe.setRecipePrice(doublePrice);
            recipe.setRecipeRemain(intRemain);
            recipe.setRecipeNotice(recipeNotice);
            recipeDao.save(recipe);
        }
        return ErrorsHandle.SUCCESS;
    }

}
