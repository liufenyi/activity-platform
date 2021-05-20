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
 * @describe 活动奖励库存表实体类
 */
@Data
@TableName("activity_reward")
public class ActivityRewardPO implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 主键id
         */
                @TableId(value = "activity_reward_id", type = IdType.ASSIGN_ID)
                private Long activityRewardId;

        /**
         * 总数
         */
    @TableField("stock_total")
        private Integer stockTotal;

        /**
         * 剩余数量
         */
    @TableField("stock_remain")
        private Integer stockRemain;

        /**
         * 已使用数量
         */
    @TableField("stock_used")
        private Integer stockUsed;

        /**
         * 关联的活动id
         */
    @TableField("activity_id")
        private Long activityId;

        /**
         * 类型
         */
    @TableField("reward_type")
        private Integer rewardType;

        /**
         * 关联的奖励对应id
         */
    @TableField("reward_id")
        private Long rewardId;

        /**
         * 奖励发放规则
         */
    @TableField("rule")
        private String rule;

        /**
         * 创建时间
         */
                @TableField(value = "create_time", fill = FieldFill.INSERT)
        private Long createTime;

        /**
         * 更新时间
         */
    @TableField("op_time")
        private Long opTime;

        /**
         * 是否有效
         */
    @TableField("is_valid")
        private Integer isValid;

        /**
         * 版本
         */
    @TableField("last_ver")
        private Integer lastVer;

        /**
         * 扩展字段
         */
    @TableField("extend_field")
        private String extendField;


        }