package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.ShopEntity;
import cn.zucc.edu.blm.bean.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserEntity,Integer> {

}
