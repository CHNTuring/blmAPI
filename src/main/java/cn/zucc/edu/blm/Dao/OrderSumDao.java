package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.OrderSum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderSumDao extends JpaRepository<OrderSum,Integer> {

    List<OrderSum> findByUserId(int UserId);

    OrderSum findByOrderId(int orderId);

    @Query(value = "select SUM(ordersum) from order_sum where shop_id=?1 and DATEDIFF(NOW(), order_start_time)<?2 and order_status='完成'", nativeQuery = true)
    Optional<Double> findSumByShopId(int shopId, int days);

}
