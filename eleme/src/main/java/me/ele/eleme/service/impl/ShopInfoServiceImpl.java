package me.ele.eleme.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import me.ele.eleme.domain.ShopInfo;
import me.ele.eleme.service.ShopInfoService;
import me.ele.eleme.mapper.ShopInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
* @author lenovo
* @description 针对表【shop_info(商铺信息表)】的数据库操作Service实现
* @createDate 2022-08-12 19:45:26
*/
@Service
public class ShopInfoServiceImpl extends ServiceImpl<ShopInfoMapper, ShopInfo>
    implements ShopInfoService{

}




