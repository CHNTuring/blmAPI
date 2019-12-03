package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.OrderSum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderSumDao extends JpaRepository<OrderSum,Integer> {

    List<OrderSum> findByUserId(int UserId);

    OrderSum findByOrderId(int orderId);
}
