package cn.zucc.edu.blm.Dao;

import cn.zucc.edu.blm.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

}
