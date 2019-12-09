package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.OrderDao;
import cn.zucc.edu.blm.Dao.OrderInfDao;
import cn.zucc.edu.blm.Dao.RecipeDao;
import cn.zucc.edu.blm.bean.OrderInf;
import cn.zucc.edu.blm.bean.Orders;
import cn.zucc.edu.blm.bean.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 订单详情
 */
@RestController
@CrossOrigin
@RequestMapping("/OrderInf")
public class OrderInfController {
    @Autowired
    private OrderInfDao orderInfDao;
    @Autowired
    private RecipeDao recipeDao;
    @Autowired
    private OrderDao orderDao;

    @GetMapping("/getOrderInfList")
    public List<OrderInf> getOrderInfList(@RequestParam(value = "orderId") int orderId) {
        List lst = new ArrayList();
        lst = orderInfDao.findByOrderId(orderId);
        return lst;
    }

    @GetMapping("/addOrderInf")
    public Integer addOrderInf(@RequestParam(value = "recipe_id") int recipe_id, @RequestParam(value = "order_id") int order_id,
                               @RequestParam(value = "list_id") int list_id, @RequestParam(value = "order_recipe_number") int order_recipe_number) {

        OrderInf orderInf = new OrderInf();
        orderInf.setRecipeId(recipe_id);
        orderInf.setListId(list_id);
        orderInf.setOrderId(order_id);
        orderInf.setOrderRecipeNumber(order_recipe_number);
        orderInfDao.save(orderInf);

        Optional<Recipe> optionalRecipe = recipeDao.findById(recipe_id);
        if (optionalRecipe.isPresent()) {
            Recipe recipe = optionalRecipe.get();
            recipe.setMonthlySale(recipe.getMonthlySale() + order_recipe_number);
            if (recipe.getRecipeRemain() < order_recipe_number) {
                List<OrderInf> deleteOrderInfList = orderInfDao.findByOrderId(order_id);
                for (OrderInf deleteOrderInf : deleteOrderInfList) {
                    Recipe deleteRecipe = recipeDao.findById(deleteOrderInf.getRecipeId()).orElse(null);
                    deleteRecipe.setMonthlySale(deleteRecipe.getMonthlySale() - order_recipe_number);
                    deleteRecipe.setRecipeRemain(deleteRecipe.getRecipeRemain() + order_recipe_number);
                    recipeDao.save(deleteRecipe);
                }
                orderDao.deleteById(order_id);

                return recipe_id;
            }
            recipe.setRecipeRemain(recipe.getRecipeRemain() - order_recipe_number);
            if (recipe.getRecipeRemain() == order_recipe_number) {
                recipe.setRecipeStatus("售罄");
            }
            recipeDao.save(recipe);

        }
        return 0;
    }

}
