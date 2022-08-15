package me.ele.eleme.mapper;

import me.ele.eleme.domain.ShopInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lenovo
* @description 针对表【shop_info(商铺信息表)】的数据库操作Mapper
* @createDate 2022-08-12 19:45:26
* @Entity me.ele.eleme.domain.ShopInfo
*/

@Mapper
public interface ShopInfoMapper extends BaseMapper<ShopInfo> {

}




