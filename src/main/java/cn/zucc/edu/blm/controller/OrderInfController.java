package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.OrderDao;
import cn.zucc.edu.blm.Dao.OrderInfDao;
import cn.zucc.edu.blm.bean.OrderInfEntity;
import cn.zucc.edu.blm.bean.OrdersEntity;
import cn.zucc.edu.blm.json.bean.ListObject;
import cn.zucc.edu.blm.json.status.StatusHouse;
import cn.zucc.edu.blm.json.util.JackJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 *  订单详情
 */
@RestController
@RequestMapping("/OrderInf")
public class OrderInfController {
    @Autowired
    private OrderInfDao orderInfDao;

    @GetMapping("/getOrderInfList")
    public List<OrderInfEntity> getOrderInfList(@RequestParam(value = "orderId") int orderId){
        List lst=new ArrayList();
        lst=orderInfDao.findByOrderId(orderId);
        return  lst;
    }
}
