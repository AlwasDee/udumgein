package me.ele.eleme.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import me.ele.eleme.domain.ShopInfo;
import me.ele.eleme.service.ShopInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopInfoControllor {
    @Autowired
    private ShopInfoService shopInfoService;

    @RequestMapping("/list")
    public List<ShopInfo> list(){
        return shopInfoService.list();
    }

    @RequestMapping("/one")
    public ShopInfo one(int id){
        return shopInfoService.getById(id);
    }

    @RequestMapping("/listByCate")
    public List<ShopInfo> listByCate(ShopInfo shopInfo){
        System.out.println(shopInfo);
        QueryWrapper<ShopInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cateid",shopInfo.getCateid());
        return shopInfoService.list(queryWrapper);
    }
}
