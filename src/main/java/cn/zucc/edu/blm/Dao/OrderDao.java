package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Orders,Integer> {

    public List<Orders> findByUserId(int userId);

}
