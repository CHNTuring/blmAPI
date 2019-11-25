package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.OrderDao;
import cn.zucc.edu.blm.bean.OrdersEntity;
import cn.zucc.edu.blm.json.bean.ListObject;
import cn.zucc.edu.blm.json.status.StatusHouse;
import cn.zucc.edu.blm.json.util.JackJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YL
 * 2019-11-24 14:54
 * @Controller + @ResponseBody = @RestController
 */
@RestController
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	private OrderDao orderDao;

	@GetMapping("/getOrderList")
	public List<OrdersEntity> getOrderList(@RequestParam(value = "userId") int userId) {
		OrdersEntity ordersEntity=new OrdersEntity();
		ordersEntity.setUserId(userId);
		org.springframework.data.domain.Example example = Example.of(ordersEntity);
		List<OrdersEntity> lst=new ArrayList<>();
		lst=orderDao.findByUserId(userId);
		return lst;
	}
}
