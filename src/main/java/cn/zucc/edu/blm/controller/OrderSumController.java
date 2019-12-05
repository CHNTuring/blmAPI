package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.OrderSumDao;
import cn.zucc.edu.blm.bean.OrderSum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/OrderSum")
public class OrderSumController {

    @Autowired
    private OrderSumDao orderSumDao;

    @GetMapping("/getOrderSumIdList")
    public List<Integer> getOrderSumIdList(@RequestParam(value = "userId")int userId){
        List<Integer> response=new ArrayList<>();
        List<OrderSum> lst=orderSumDao.findByUserId(userId);
        for(OrderSum a:lst){
            response.add(a.getOrderId());
        }
        return response;
    }

    @GetMapping("/getOrderSumById")
    public OrderSum getOrderSumById(@RequestParam(value = "orderId")int orderId){
        return orderSumDao.findByOrderId(orderId);
    }

    @GetMapping("/getOrderSumList")
    public List<OrderSum> getOrderSumList(@RequestParam(value = "userId")int userId){
        List<OrderSum> lst=new ArrayList<>();
        lst=orderSumDao.findAll();
        for(int i=0;i<lst.size();i++){
            lst.get(i).setShopTrademark(null);
        }
        return lst;
    }

    @GetMapping("/getOrderSumTrademark")
    public OrderSum getOrderSumTrademark(@RequestParam(value = "orderId")int orderId){
        return orderSumDao.findById(orderId).orElse(null);
    }
}
