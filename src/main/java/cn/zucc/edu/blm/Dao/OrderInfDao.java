package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.OrderInfEntity;
import cn.zucc.edu.blm.bean.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderInfDao extends JpaRepository<OrderInfEntity,Integer> {
    public List<OrderInfEntity> findByOrderId (int orderId);
}
