package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.ShopDao;
import cn.zucc.edu.blm.Dao.ShopEvaluateDao;
import cn.zucc.edu.blm.bean.Shop;
import cn.zucc.edu.blm.bean.ShopEvaluate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/ShopEvaluate")
public class ShopEvaluateController {

    @Autowired
    private ShopEvaluateDao shopEvaluateDao;
    @Autowired
    private ShopDao shopDao;


    @GetMapping("/addShopEvaluate")
    public void addShopEvaluate(@RequestParam(value = "shopId") int shopId, @RequestParam(value = "orderId") int orderId,
                                @RequestParam(value = "shopGrade") double shopGrade, @RequestParam(value = "userId") int userId,
                                @RequestParam(value = "shopEvaluateContent") String shopEvaluateContent) {
        ShopEvaluate shopEvaluate = new ShopEvaluate();
        shopEvaluate.setShopId(shopId);
        shopEvaluate.setUserId(userId);
        shopEvaluate.setShopEvaluateContent(shopEvaluateContent);
        shopEvaluate.setShopGrade(shopGrade);
        shopEvaluate.setShopEvaluateOrder(orderId);
        shopEvaluateDao.save(shopEvaluate);

        Optional<Shop> optionalshop = shopDao.findById(shopId);
        if (optionalshop.isPresent()) {
            Shop shop = optionalshop.get();
            shop.setShopCore(shopEvaluateDao.getshopgrade(shopId));
            shopDao.save(shop);
        }

    }
}
