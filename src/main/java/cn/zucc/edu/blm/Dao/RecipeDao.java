package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.OrdersEntity;
import cn.zucc.edu.blm.bean.RecipeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeDao extends JpaRepository<RecipeEntity,Integer> {

    public List<RecipeEntity> findByShopId(int shopId);


}
