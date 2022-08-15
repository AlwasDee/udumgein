package me.ele.eleme.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 商铺信息表
 * @TableName shop_info
 */
@TableName(value ="shop_info")
@Data
public class ShopInfo implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商店ID
     */
    @TableField(value = "shop_id")
    private Integer shopId;

    /**
     * 商铺所属的TAG
     */
    @TableField(value = "tag")
    private String tag;

    /**
     * 商品名称
     */
    @TableField(value = "shopname")
    private String shopname;

    /**
     * 联系人
     */
    @TableField(value = "contact_man")
    private String contactMan;

    /**
     * 联系电话
     */
    @TableField(value = "contact_mobile")
    private String contactMobile;

    /**
     * 门店类型
     */
    @TableField(value = "cateid")
    private Integer cateid;

    /**
     * 营业开始时间
     */
    @TableField(value = "begin_time")
    private Integer beginTime;

    /**
     * 营业结束时间
     */
    @TableField(value = "end_time")
    private Integer endTime;

    /**
     * 门店图片
     */
    @TableField(value = "store_img")
    private String storeImg;

    /**
     * 店内图片
     */
    @TableField(value = "instore_img")
    private String instoreImg;

    /**
     * logo图片
     */
    @TableField(value = "logo_img")
    private String logoImg;

    /**
     * 经度
     */
    @TableField(value = "longitude")
    private String longitude;

    /**
     * 纬度
     */
    @TableField(value = "latitude")
    private String latitude;

    /**
     * 省
     */
    @TableField(value = "province")
    private String province;

    /**
     * 市
     */
    @TableField(value = "city")
    private String city;

    /**
     * 区
     */
    @TableField(value = "district")
    private String district;

    /**
     * 详细地址
     */
    @TableField(value = "address")
    private String address;

    /**
     * 街道/门牌号
     */
    @TableField(value = "street")
    private String street;

    /**
     * 外卖电话
     */
    @TableField(value = "mobile")
    private String mobile;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 其他图片
     */
    @TableField(value = "images")
    private String images;

    /**
     * 商家公告
     */
    @TableField(value = "notice")
    private String notice;

    /**
     * 平均评分
     */
    @TableField(value = "score")
    private Double score;

    /**
     * 配送时间
     */
    @TableField(value = "send_time")
    private String sendTime;

    /**
     * 餐盒费用
     */
    @TableField(value = "box_cost")
    private Integer boxCost;

    /**
     * 配送费用
     */
    @TableField(value = "send_cost")
        private Integer sendCost;

    /**
     * 起送消费
     */
    @TableField(value = "floor_send_cost")
    private Integer floorSendCost;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}