package cn.zucc.edu.blm.controller;


import cn.zucc.edu.blm.Dao.ShopDao;
import cn.zucc.edu.blm.bean.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    public List<Shop> getShopList(){
        List<Shop> lst;
        lst=shopDao.findAll();
        for(int i=0;i<lst.size();i++){
            lst.get(i).setShopTrademark(null);
        }
        return lst;
    }

    @GetMapping("/getTrademarkById")
    public byte[] getTrademarkById(@RequestParam(value = "shopId") int shopId) {
        Shop shop = shopDao.findById(shopId).orElse(null);
        return shop.getShopTrademark();
    }


    @GetMapping("/getShopIdList")
    public List<Integer> getShopIdList() {
        List<Shop> lst;
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
        return shopDao.findShopByShopTelAndShopPwd(shopTel, shopPwd);
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
    public Shop shopInfoModify(HttpServletRequest request) {
        MultipartHttpServletRequest params = ((MultipartHttpServletRequest) request);
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("shopTrademark");
        MultipartFile shopTrademark = null;
        if (files.size() != 0) {
            shopTrademark = files.get(0);
        }
        int shopId = Integer.valueOf(params.getParameter("shopId"));
        String shopName = params.getParameter("shopName");
        String shopAddr = params.getParameter("shopAddr");

        Optional<Shop> shopOptional = shopDao.findById(shopId);
        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();
            shop.setShopAddress(shopAddr);
            shop.setShopName(shopName);
            try {
                if (shopTrademark != null && shopTrademark.getInputStream().available() != 0) {
                    byte[] byteArray = new byte[shopTrademark.getInputStream().available()];
                    shopTrademark.getInputStream().read(byteArray);
                    shop.setShopTrademark(byteArray);
                }
            } catch (IOException e) {
                return null;
            }
            return shopDao.save(shop);
        }
        return null;
    }

    @GetMapping("/getMonthlyTrade")
    public Integer getMonthlyTrade(@RequestParam(value = "shopId") int shopId) {
        return shopDao.monthlytrade(shopId);
    }

    @GetMapping("/logout")
    public String logout(@RequestParam(value = "shopId") int shopId){
        Optional<Shop> shopOptional = shopDao.findById(shopId);
        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();
            shop.setShopStatus("离线");
            shopDao.save(shop);
            return ErrorsHandle.SUCCESS;
        }
        return null;
    }

    @GetMapping("/viewOrders")
    public String viewOrders(@RequestParam(value = "shopId") Integer shopId) {
        Optional<Shop> shopOptional = shopDao.findById(shopId);
        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();
            shop.setShopStatus("在线");
            shopDao.save(shop);
            return ErrorsHandle.SUCCESS;
        }
        return null;
    }

}
