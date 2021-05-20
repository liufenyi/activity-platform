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
 * @describe 优惠券模板表实体类
 */
@Data
@TableName("coupon_kind")
public class CouponKindPO implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 优惠券类型id
         */
                @TableId(value = "coupon_kind_id", type = IdType.ASSIGN_ID)
                private Long couponKindId;

        /**
         * 优惠名称
         */
    @TableField("name")
        private String name;

        /**
         * 优惠券类型
         */
    @TableField("coupon_type")
        private Integer couponType;

        /**
         * 优惠金额
         */
    @TableField("price")
        private Integer price;

        /**
         * 有效时间
         */
    @TableField("effect_time")
        private Long effectTime;

        /**
         * 规则列表，json串
         */
    @TableField("rules")
        private String rules;

        /**
         * 适用范围,位运算表示 1<<0:预售,1<<1 堂食 1<<2 外卖
         */
    @TableField("use_range")
        private Integer useRange;

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
         * 修改时间毫秒
         */
    @TableField("op_time")
        private Long opTime;


        }