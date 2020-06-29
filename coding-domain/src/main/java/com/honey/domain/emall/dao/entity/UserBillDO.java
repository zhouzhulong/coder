package com.honey.domain.emall.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * 用户账单表
 * </p>
 *
 * @author zlzhou
 * @since 2020-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_bill")
public class UserBillDO extends Model<UserBillDO> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户标识
     */
    private String userId;

    /**
     * 用户手机号
     */
    private String telno;

    private Double money;

    /**
     * 类型 1、购买商品返利金额 2、好友+商品返利  3、提现充红包金额
     */
    private String type;

    /**
     * 状态 1、已完成  2、正在处理  3、充值失败
     */
    private String status;

    /**
     * 关联的id，如果类型是购买商品返利，则为订单id；如果是充值提现，则为充值记录id
     */
    private String orderId;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 充值时间
     */
    private LocalDateTime createTime;

    /**
     * 业务id，充红包时使用，每次充值时使用的值需要保持不同
     */
    private String billId;

    /**
     * 商城来源，jd：京东 tb：淘宝，pdd：拼多多
     */
    private String mallSource;

    /**
     * 描述
     */
    @TableField(value = "`desc`")
    private String desc;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
