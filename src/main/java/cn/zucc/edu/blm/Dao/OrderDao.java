package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.OrdersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<OrdersEntity,Integer> {

    public List<OrdersEntity> findByUserId(int userId);

}
