package cn.zucc.edu.blm.controller;

import cn.zucc.edu.blm.Dao.ActivityDao;
import cn.zucc.edu.blm.bean.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Activity")
public class ActivityController {

    @Autowired
    private ActivityDao activityDao;

    @GetMapping("getActivitiesByShopId")
    public List<Activity> getActivitiesByShopId(@RequestParam(value = "shopId") int shopId) {
        return activityDao.findByShopId(shopId);
    }
}
