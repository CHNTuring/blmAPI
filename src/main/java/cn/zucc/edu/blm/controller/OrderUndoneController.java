package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.OrderUndoneDao;
import cn.zucc.edu.blm.bean.OrderUndone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/OrderUndone")
public class OrderUndoneController {

    @Autowired
    private OrderUndoneDao orderUndoneDao;

    @GetMapping("/getOrderUndoneList")
    public List<OrderUndone> getOrderUndoneList(@RequestParam(value = "shopId") int shopId, @RequestParam(value = "orderId") int orderId) {
        return orderUndoneDao.getOrderUndoneListdao(shopId, orderId);
    }

    @GetMapping("/getOrderDoneList")
    public List<OrderUndone> getOrderDoneList(@RequestParam(value = "shopId") int shopId) {
        List<OrderUndone> lst = new ArrayList<>();
        List<OrderUndone> lst2 = new ArrayList<>();
        lst = orderUndoneDao.findByShopIdAndOrderStatus(shopId, "待取");
        lst.addAll(orderUndoneDao.findByShopIdAndOrderStatus(shopId, "完成"));
        for(OrderUndone orderUndone:lst){
            orderUndone.setRecipeImage(null);
            lst2.add(orderUndone);
        }
        return lst2;
    }
}
