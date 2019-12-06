package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface OrderDao extends JpaRepository<Orders,Integer> {

    List<Orders> findByUserId(int userId);

    List<Orders> findByShopIdAndOrderStatus(int shopId, String status);

    List<Orders> findByOrderStatus(String status);

    @Query(value = "select COUNT(*) from orders where shop_id=?1 and DATEDIFF(NOW(), order_start_time)<?2 and order_status='完成'", nativeQuery = true)
    Optional<Integer> findCountByDays(int shopId, int days);

}