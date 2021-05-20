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
 * @describe 优惠券消费记录表实体类
 */
@Data
@TableName("coupon_consume_detail")
public class CouponConsumeDetailPO implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 主键ID
         */
                @TableId(value = "coupon_consume_detail_id", type = IdType.ASSIGN_ID)
                private Long couponConsumeDetailId;

        /**
         * 用户id
         */
    @TableField("customer_register_id")
        private String customerRegisterId;

        /**
         * 优惠券id
         */
    @TableField("coupon_customer_id")
        private Long couponCustomerId;

        /**
         * 优惠券金额
         */
    @TableField("price")
        private Integer price;

        /**
         * 实际抵扣金额
         */
    @TableField("deduct_fee")
        private Integer deductFee;

        /**
         * 订单id
         */
    @TableField("order_id")
        private String orderId;

        /**
         * 支付快照Id
         */
    @TableField("snapshot_id")
        private String snapshotId;

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
         * 所属活动id
         */
    @TableField("op_time")
        private Long opTime;

        /**
         * 店铺ID
         */
    @TableField("entity_id")
        private String entityId;


        }