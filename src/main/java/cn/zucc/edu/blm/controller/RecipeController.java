package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.RecipeDao;
import cn.zucc.edu.blm.Dao.ShopDao;
import cn.zucc.edu.blm.bean.RecipeEntity;
import cn.zucc.edu.blm.bean.ShopEntity;
import cn.zucc.edu.blm.json.bean.ListObject;
import cn.zucc.edu.blm.json.status.StatusHouse;
import cn.zucc.edu.blm.json.util.JackJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Recipe")
public class RecipeController {
    @Autowired
    private RecipeDao recipeDao;

    @GetMapping("/getRecipeList")
    public List<RecipeEntity> getRecipeList(@RequestParam(value = "shopId") int shopId){
        List lst=new ArrayList();
        lst=recipeDao.findByShopId(shopId);
        return  lst;
    }
}
