package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.OrderDao;
import cn.zucc.edu.blm.bean.Orders;
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
@CrossOrigin
@RequestMapping("/Order")
public class OrderController {

	@Autowired
	private OrderDao orderDao;

	@GetMapping("/getOrderList")
	public List<Orders> getOrderList(@RequestParam(value = "userId") int userId) {
		Orders ordersEntity=new Orders();
		ordersEntity.setUserId(userId);
		org.springframework.data.domain.Example example = Example.of(ordersEntity);
		List<Orders> lst=new ArrayList<>();
		lst=orderDao.findByUserId(userId);
		return lst;
	}

}
