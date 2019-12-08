package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.OrderDao;
import cn.zucc.edu.blm.Dao.OrderSumDao;
import cn.zucc.edu.blm.Dao.RecipeDao;
import cn.zucc.edu.blm.analyzeBean.OrderAnalyze;
import cn.zucc.edu.blm.analyzeBean.RecipeAnalyze;
import cn.zucc.edu.blm.bean.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/OrderAnalyze")
public class OrderAnalyzeController {
    @Autowired
    private OrderDao dao;
    @Autowired
    private OrderSumDao sumDao;
    @Autowired
    private RecipeDao recipeDao;

    /**
     * 获得昨天、7天、半个月、一个月该店家销售量和金额
     */
    @GetMapping("getOrderAnalyzeByShopId")
    public List<OrderAnalyze> getOrderAnalyzeByShopId(@RequestParam(value = "shopId")int shopId){
        List<OrderAnalyze> result = new ArrayList<>();

        OrderAnalyze order_yesterday = new OrderAnalyze();

        order_yesterday.setCount(dao.findCountByDays(shopId, 1).orElse(0));
        order_yesterday.setSum(sumDao.findSumByShopId(shopId, 1).orElse(0.0));
        order_yesterday.setState(1);
        result.add(order_yesterday);

        OrderAnalyze order_weekago = new OrderAnalyze();
        order_weekago.setCount(dao.findCountByDays(shopId, 7).orElse(0));
        order_weekago.setSum(sumDao.findSumByShopId(shopId, 7).orElse(0.0));
        order_weekago.setState(2);
        result.add(order_weekago);

        OrderAnalyze order_fortnight = new OrderAnalyze();
        order_fortnight.setCount(dao.findCountByDays(shopId, 15).orElse(0));
        order_fortnight.setSum(sumDao.findSumByShopId(shopId, 15).orElse(0.0));
        order_fortnight.setState(3);
        result.add(order_fortnight);

        OrderAnalyze order_month = new OrderAnalyze();
        order_month.setCount(dao.findCountByDays(shopId, 30).orElse(0));
        order_month.setSum(sumDao.findSumByShopId(shopId, 30).orElse(0.0));
        order_month.setState(4);
        result.add(order_month);

        return result;
    }

    /**
     * 获得一个月该店家各菜谱销售数量
     */
    @GetMapping("getORecipeAnalyzeByShopId")
    public List<RecipeAnalyze> getRecipeAnalyzeByShopId(@RequestParam(value = "shopId")int shopId){
        List<Recipe> recipes = recipeDao.findByShopId(shopId);
        List<RecipeAnalyze> result = new ArrayList<>();
        for (Recipe recipe : recipes) {
            if (recipe.getMonthlySale() == 0)
                continue;
            RecipeAnalyze analyze = new RecipeAnalyze();
            analyze.setRecipeName(recipe.getRecipeName());
            analyze.setCount(recipe.getMonthlySale());
            result.add(analyze);
        }
        return result;
    }

    @GetMapping("getCountByDayOfMonth")
    public List<Integer> getCountByDayOfMonth(@RequestParam(value = "shopId")int shopId){
        List<Integer> result = new ArrayList<>();
        int days = 30, count = 0;
        for (int i = 1; i <= days; i++) {
            result.add(dao.findCountByDays(shopId, i).orElse(0) - count);
            count = dao.findCountByDays(shopId, i).orElse(0);
        }

        return result;
    }

}
