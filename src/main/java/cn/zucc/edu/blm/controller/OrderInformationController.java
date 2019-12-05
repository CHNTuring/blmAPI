package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.OrderInformationDao;
import cn.zucc.edu.blm.bean.OrderInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/OrderInformation")
public class OrderInformationController {

    @Autowired
    private OrderInformationDao orderInformationDao;

    @GetMapping("/getOrderInformationList")
    public List<OrderInformation> getOrderInformationList(@RequestParam(value = "orderId")int orderId){
            return orderInformationDao.findAll();
    }
}
