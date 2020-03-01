package com.dhr.entity;

import lombok.Data;

import java.util.Date;

/**
 * Class description 订单表
 *
 *
 * @version        $version$, $date$, 19/01/14
 * @author         donghuarui.
 */
@Data
public class Orders {

    /** 主键订单Id  */
    private String ordersId;

    /** 下单用户id */
    private String userId;

    /** 订单号  */
    private String number;

    /** 创建订单时间  */
    private Date createTime;

    /** 修改订单时间  */
    private Date updateTime;

    /** 备注 */
    private String note;

    /**  用户信息 */
    private User user;
}
