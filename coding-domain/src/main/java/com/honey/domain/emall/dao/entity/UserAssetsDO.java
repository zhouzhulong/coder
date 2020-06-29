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
 * 用户资产表
 * </p>
 *
 * @author zlzhou
 * @since 2020-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("user_assets")
public class UserAssetsDO extends Model<UserAssetsDO> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String userId;

    /**
     * 累计返利：用户购物返利+好友返利
     */
    private Double totalAssets;

    /**
     * 用户购物返利
     */
    private Double shopAssets;

    /**
     * 好友返利
     */
    private Double friendAssets;

    /**
     * 待返利
     */
    private Double waitAssets;

    /**
     * 已充值金额
     */
    private Double usedAssets;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 分享商品待返利金额
     */
    private Double shareWaitsAssets;

    /**
     * 分享商品已返利金额
     */
    private Double shareAssets;

    /**
     * 好友返利待返利金额
     */
    private Double friendWaitsAssets;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
