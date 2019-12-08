package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShopDao extends JpaRepository<Shop, Integer> {

    Shop findShopByShopTelAndShopPwd(String shopTel,String shopPwd);

    Shop findShopByShopTel(String shopTel);

    @Query(value = "select count(*) from orders where shop_id= ?1",nativeQuery = true)
    public Integer monthlytrade(int shopId);

}
