package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDao extends JpaRepository<Orders,Integer> {

    public List<Orders> findByUserId(int userId);

    List<Orders> findByShopIdAndOrderStatus(int shopId,String status);

    List<Orders> findByOrderStatus(String status);

    @Query(value = "SELECT MAX(temporary_id) FROM orders WHERE shop_id",nativeQuery = true)
    Integer getMaxTemp(int shopId);
}
