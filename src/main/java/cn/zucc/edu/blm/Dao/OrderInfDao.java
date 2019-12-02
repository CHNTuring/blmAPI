package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.OrderInf;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderInfDao extends JpaRepository<OrderInf,Integer> {
    public List<OrderInf> findByOrderId (int orderId);
}
