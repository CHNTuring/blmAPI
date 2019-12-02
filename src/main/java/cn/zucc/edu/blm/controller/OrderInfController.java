package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.OrderInfDao;
import cn.zucc.edu.blm.bean.OrderInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *  订单详情
 */
@RestController
@CrossOrigin
@RequestMapping("/OrderInf")
public class OrderInfController {
    @Autowired
    private OrderInfDao orderInfDao;

    @GetMapping("/getOrderInfList")
    public List<OrderInf> getOrderInfList(@RequestParam(value = "orderId") int orderId){
        List lst=new ArrayList();
        lst=orderInfDao.findByOrderId(orderId);
        return  lst;
    }
}
