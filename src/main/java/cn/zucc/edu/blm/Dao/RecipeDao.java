package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeDao extends JpaRepository<Recipe,Integer> {

    public List<Recipe> findByShopId(int shopId);


}
