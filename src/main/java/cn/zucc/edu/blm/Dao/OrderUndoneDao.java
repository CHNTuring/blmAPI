package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.OrderUndone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderUndoneDao extends JpaRepository<OrderUndone, Integer> {
    @Query(value = "select * from order_undone where order_status='下单' and shop_id= ?1 and order_id> ?2", nativeQuery = true)
    List<OrderUndone> getOrderUndoneListdao(int shopId, int orderId);


    List<OrderUndone> findByShopIdAndOrderStatus(int shopId, String orderStatus);
}
