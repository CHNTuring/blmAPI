package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.OrderInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderInformationDao extends JpaRepository<OrderInformation,Integer> {

    List<OrderInformation> findByOrderId(int orderId);
}
