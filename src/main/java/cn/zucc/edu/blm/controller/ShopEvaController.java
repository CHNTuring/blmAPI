package cn.zucc.edu.blm.controller;


import cn.zucc.edu.blm.Dao.ShopEvaDao;
import cn.zucc.edu.blm.bean.ShopEva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ShopEvaController")
public class ShopEvaController {

    @Autowired
    private ShopEvaDao shopEvaDao;

    @GetMapping("/getShopEva")
    public List<ShopEva> getShopEva(@RequestParam(value = "shopId") int shopId) {
        return shopEvaDao.findByShopId(shopId);
    }
}
