package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.OrderDao;
import cn.zucc.edu.blm.bean.Orders;
import org.hibernate.criterion.Order;
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

	@GetMapping("/getOrderListDone")
	public List<Orders> getOrderListDone(@RequestParam(value = "shopId") int shopId){
		Orders ordersEntity=new Orders();
		ordersEntity.setShopId(shopId);
		Example example=Example.of(ordersEntity);
		List<Orders> lst=orderDao.findByShopIdAndOrderStatus(shopId,"完成");
		return lst;
	}

	@GetMapping("/getOrderListUndone")
	public List<Orders> getOrderListUndone(@RequestParam(value = "shopId")int shopId){
		List<Orders> lst=orderDao.findByShopIdAndOrderStatus(shopId,"下单");
		return lst;
	}

	@GetMapping("/getOrderListId")
	public List<Integer> getOrderListId(@RequestParam(value = "userId")int userId){
		List<Orders> lst=new ArrayList<>();
		List<Integer> response=new ArrayList<>();
		lst=orderDao.findByUserId(userId);
		for(Orders a:lst){
			response.add(a.getOrderId());
		}

		return response;
	}

	@GetMapping("/getOrder")
	public Orders getOrder(@RequestParam(value = "OrderId")int orderId){
		return orderDao.findById(orderId).orElse(null);
	}
}
