package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.OrderUndone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderUndoneDao extends JpaRepository<OrderUndone,Integer> {
    List<OrderUndone> findByShopIdAndOrderStatusAndOrderIdAfter(int shopId,String orderStatus,int orderId);

    List<OrderUndone> findByShopIdAndOrderStatus(int shopId,String orderStatus);
}
