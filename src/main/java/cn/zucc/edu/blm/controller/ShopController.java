package cn.zucc.edu.blm.controller;


import cn.zucc.edu.blm.Dao.ShopDao;
import cn.zucc.edu.blm.bean.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/Shop")
public class ShopController {
    @Autowired
    private ShopDao shopDao;

    @GetMapping("/getShopList")
    public List<Shop> getShopList() {
        List lst = new ArrayList();
        lst = shopDao.findAll();
        return lst;
    }

    @GetMapping("/getShopIdList")
    public List<Integer> getShopIdList() {
        List<Shop> lst = new ArrayList<Shop>();
        List<Integer> response = new ArrayList<>();
        lst = shopDao.findAll();
        for (Shop a : lst) {
            response.add(a.getShopId());
        }

        return response;
    }

    @GetMapping("/getShopById")
    public Shop getShopById(@RequestParam(value = "shopId") int shopId) {
        return shopDao.findById(shopId).orElse(null);
    }

    @GetMapping("/modifyPwd")
    public Shop modifyPwd(@RequestParam(value = "shopId") int shopId, @RequestParam(value = "shopPwd") String shopPwd) {
        Optional<Shop> shopOptional = shopDao.findById(shopId);
        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();
            shop.setShopId(shopId);
            shop.setShopPwd(shopPwd);
            return shopDao.save(shop);
        }
        return null;
    }

    @GetMapping("/login")
    public Shop login(@RequestParam(value = "shopTel") String shopTel, @RequestParam(value = "shopPwd") String shopPwd) {
        Shop shop = shopDao.findShopByShopTelAndShopPwd(shopTel, shopPwd);
        if (shop != null) {
            shop.setShopStatus("在线");
            return shopDao.save(shop);
        }
        return null;
    }

    @GetMapping("/register")  //自增问题
    public String register(@RequestParam(value = "shopTel") String shopTel, @RequestParam(value = "shopPwd") String shopPwd) {
        Shop shop = shopDao.findShopByShopTel(shopTel);
        if (shop != null) {
            return ErrorsHandle.REGISTER_FAILED;
        } else {
            shop = new Shop();
            shop.setShopStatus("离线");
            shop.setShopPwd(shopPwd);
            shop.setShopTel(shopTel);
            shopDao.saveAndFlush(shop);
        }
        return ErrorsHandle.SUCCESS;
    }

    @GetMapping("/notice")
    public Shop notice(@RequestParam(value = "shopId") Integer shopId, @RequestParam(value = "shopNotice") String shopNotice) {
        Optional<Shop> shopOptional = shopDao.findById(shopId);
        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();
            shop.setShopNotice(shopNotice);
            return shopDao.save(shop);
        }
        return null;
    }

    @PostMapping("/shopInfoModify")
    public Shop shopInfoModify(@RequestParam(value = "shopId") Integer shopId, @RequestParam(value = "shopName") String shopName,
                               @RequestParam(value = "shopAddr") String shopAddr/*, @RequestParam(value = "shopTrademark") MultipartFile shopTrademark*/) {
        Optional<Shop> shopOptional = shopDao.findById(shopId);
        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();
            shop.setShopAddress(shopAddr);
            shop.setShopName(shopName);
            /*try {
                shop.setShopTrademark(new byte[shopTrademark.getInputStream().available()]);
            } catch (IOException e) {
                return null;
            }*/
            return shopDao.save(shop);
        }
        return null;
    }

    @RequestMapping("/shopImageModify")
    public String shopImageModify(MultipartFile file, String type) {
        /*Optional<Shop> shopOptional = shopDao.findById(shopId);
        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();
            try {
                shop.setShopTrademark(file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "图片修改成功";
        }
        return String.valueOf(file.isEmpty());*/
        return "ok";
    }
}
