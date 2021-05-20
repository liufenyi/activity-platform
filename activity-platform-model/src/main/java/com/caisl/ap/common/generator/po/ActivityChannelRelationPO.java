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
 * @describe 活动渠道关联表实体类
 */
@Data
@TableName("activity_channel_relation")
public class ActivityChannelRelationPO implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 主键
         */
                @TableId(value = "activity_channel_relation_id", type = IdType.ASSIGN_ID)
                private Long activityChannelRelationId;

        /**
         * 活动ID
         */
    @TableField("activity_id")
        private Long activityId;

        /**
         * 推广渠道ID
         */
    @TableField("promotion_channel_id")
        private Long promotionChannelId;

        /**
         * 活动推广链接
         */
    @TableField("activity_url")
        private String activityUrl;

        /**
         * 扩展属性
         */
    @TableField("extend_field")
        private String extendField;

        /**
         * 创建时间
         */
                @TableField(value = "create_time", fill = FieldFill.INSERT)
        private Long createTime;

        /**
         * 操作时间
         */
    @TableField("op_time")
        private Long opTime;

        /**
         * 版本号
         */
    @TableField("last_ver")
        private Integer lastVer;

        /**
         * 是否有效（0-失效 1-有效）
         */
    @TableField("is_valid")
        private Integer isValid;


        }