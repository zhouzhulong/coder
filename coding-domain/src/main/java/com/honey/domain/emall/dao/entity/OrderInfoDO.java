package com.honey.domain.emall.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单表
 * </p>
 *
 * @author zlzhou
 * @since 2020-06-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order_info")
public class OrderInfoDO extends Model<OrderInfoDO> {

    private static final long serialVersionUID=1L;

    /**
     * 订单id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 订单id
     */
    private String orderId;

    /**
     * 订单创建时间
     */
    private LocalDateTime orderTime;

    private String userId;

    /**
     * 有效码 -1：未知 2.无效-拆单 3.无效-取消 4.无效-京东帮帮主订单 5.无效-账号异常 6.无效-赠品类目不返佣 7.无效-校园订单 8.无效-企业订单 9.无效-团购订单 10.无效-开增值税专用发票订单 11.无效-乡村推广员下单 12.无效-自己推广自己下单 13.无效-违规订单 14.无效-来源与备案网址不符 15.待付款 16.已付款 17.已完成 18.已结算
     */
    private String status;

    /**
     * 结算时间 yyyyMMdd
     */
    private String payMonth;

    /**
     * 下单设备 1.pc 2.无线
     */
    private Integer orderEmt;

    /**
     * plus会员 1:是，0:否
     */
    private Integer plus;

    /**
     * 渠道推广方ID
     */
    private String unionid;

    /**
     * 用户在飞尔商城的账号唯一标识
     */
    private String keplerCustomerInfo;

    private String subUnion;

    /**
     * 商城来源，jd：京东 tb：淘宝，pdd：拼多多
     */
    private String mallSource;

    /**
     * 订单更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 订单返利状态 0 已返利 1、待返利 2 无返利
     */
    private String commissionStatus;

    private LocalDateTime createTime;

    /**
     * 用户付款时间
     */
    private LocalDateTime finishTime;

    /**
     * 充值时间
     */
    private LocalDateTime rechargeTime;

    private String rechargeStatus;

    /**
     * 预计充值时间
     */
    private LocalDateTime estimateRechargeTime;

    /**
     * 订单拉取来源1 开普勒 0 联盟 2 淘宝
     */
    private Integer orderPullSource;

    /**
     * 保存开普勒和淘宝订单商品分享者的用户ID
     */
    private String kplShareUserId;

    /**
     * 返利商品数量
     */
    private Integer rebateCommodityNum;

    /**
     * 淘宝订单ID
     */
    private String tradeId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
