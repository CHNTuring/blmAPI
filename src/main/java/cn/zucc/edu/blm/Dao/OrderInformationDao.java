package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.OrderInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInformationDao extends JpaRepository<OrderInformation,Integer> {
}
