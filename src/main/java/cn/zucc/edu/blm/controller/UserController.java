package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.ShopDao;
import cn.zucc.edu.blm.Dao.UserDao;
import cn.zucc.edu.blm.bean.UserEntity;
import cn.zucc.edu.blm.json.bean.ListObject;
import cn.zucc.edu.blm.json.bean.SingleObject;
import cn.zucc.edu.blm.json.status.StatusHouse;
import cn.zucc.edu.blm.json.util.JackJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/getUser")
    public UserEntity getUser(@RequestParam(value = "userId") int userId){
        Optional optional =userDao.findById(userId);
        return  (UserEntity) optional.orElse(null);
    }
}
