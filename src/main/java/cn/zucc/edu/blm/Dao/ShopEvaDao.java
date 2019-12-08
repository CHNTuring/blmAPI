package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.ShopEva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopEvaDao extends JpaRepository<ShopEva, Integer> {

    List<ShopEva> findByShopId(int shopId);
}
