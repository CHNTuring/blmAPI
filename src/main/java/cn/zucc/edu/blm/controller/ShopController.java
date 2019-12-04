package cn.zucc.edu.blm.controller;


import cn.zucc.edu.blm.Dao.ShopDao;
import cn.zucc.edu.blm.bean.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Shop")
public class ShopController {
    @Autowired
    private ShopDao shopDao;

    @GetMapping("/getShopList")
    public List<Shop> getShopList(){
        List<Shop> lst=new ArrayList();
        lst=shopDao.findAll();
        for(int i=0;i<lst.size();i++){
            lst.get(i).setShopTrademark(null);
        }
        return  lst;
    }

    @GetMapping("/getTrademarkById")
    public byte[] getTrademarkById(@RequestParam(value = "shopId")int shopId){
        Shop shop=shopDao.findById(shopId).orElse(null);
        return shop.getShopTrademark();
    }


    @GetMapping("/getShopIdList")
    public List<Integer> getShopIdList(){
        List<Shop> lst=new ArrayList<Shop>();
        List<Integer> response=new ArrayList<>();
        lst=shopDao.findAll();
        for(Shop a:lst){
            response.add(a.getShopId());
        }

        return response;
    }

    @GetMapping("/getShopById")
    public Shop getShopById(@RequestParam(value = "shopId") int shopId){
        return shopDao.findById(shopId).orElse(null);
    }
}
