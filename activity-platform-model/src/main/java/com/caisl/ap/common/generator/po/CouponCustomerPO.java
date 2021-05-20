package com.caisl.ap.common.generator.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.Version;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * @author huang cong
 * @create 2021-05-20 17:55
 * @describe 用户领取记录表实体类
 */
@Data
@TableName("coupon_customer")
public class CouponCustomerPO implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 优惠券id
         */
                @TableId(value = "coupon_customer_id", type = IdType.ASSIGN_ID)
                private Long couponCustomerId;

        /**
         * 用户id
         */
    @TableField("customer_register_id")
        private String customerRegisterId;

        /**
         * 优惠券模板id
         */
    @TableField("coupon_kind_id")
        private Long couponKindId;

        /**
         * 优惠券类型
         */
    @TableField("coupon_type")
        private Integer couponType;

        /**
         * 优惠券金额
         */
    @TableField("price")
        private Integer price;

        /**
         * 活动id
         */
    @TableField("activity_id")
        private Long activityId;

        /**
         * 活动类型
         */
    @TableField("activity_type")
        private Integer activityType;

        /**
         * 领取渠道
         */
    @TableField("channel")
        private String channel;

        /**
         * 生效时间
         */
    @TableField("effective_time")
        private Long effectiveTime;

        /**
         * 过期时间
         */
    @TableField("expire_time")
        private Long expireTime;

        /**
         * 状态，1:未使用，2:已使用，3:已过期
         */
    @TableField("status")
        private Integer status;

        /**
         * 扩展字段列表，json串
         */
    @TableField("extend_field")
        private String extendField;

        /**
         * 是否有效
         */
    @TableField("is_valid")
        private Integer isValid;

        /**
         * 版本号
         */
    @TableField("last_ver")
        private Integer lastVer;

        /**
         * 创建时间毫秒
         */
                @TableField(value = "create_time", fill = FieldFill.INSERT)
        private Long createTime;

        /**
         * 操作时间毫秒
         */
    @TableField("op_time")
        private Long opTime;


        }