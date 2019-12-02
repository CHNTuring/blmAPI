package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.UserDao;
import cn.zucc.edu.blm.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/getUser")
    public User getUser(@RequestParam(value = "userId") int userId){
        Optional optional =userDao.findById(userId);
        return  (User) optional.orElse(null);
    }
}
