package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityDao extends JpaRepository<Activity,Integer> {

    List<Activity> findByShopId(int shopId);


}
