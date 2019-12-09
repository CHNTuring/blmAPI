package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecipeDao extends JpaRepository<Recipe, Integer> {

    public List<Recipe> findByShopId(int shopId);

    public List<Recipe> findByShopIdAndRecipeStatus(int shopId, String recipeStatus);

    @Query(value = "select  * from recipe where shop_id = ?1 and recipe_remain>0",nativeQuery = true)
    public List<Recipe> findrecipe(int shopId);
}
