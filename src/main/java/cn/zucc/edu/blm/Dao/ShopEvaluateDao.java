package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.ShopEvaluate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShopEvaluateDao extends JpaRepository<ShopEvaluate, Integer> {

    @Query(value = "select avg(shop_grade) from shop_evaluate where shop_id=?1", nativeQuery = true)
    double getshopgrade(int shopId);
}
