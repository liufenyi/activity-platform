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
 * @describe 推广渠道配置表实体类
 */
@Data
@TableName("promotion_channel")
public class PromotionChannelPO implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 主键
         */
                @TableId(value = "promotion_channel_id", type = IdType.ASSIGN_ID)
                private Long promotionChannelId;

        /**
         * 渠道名称
         */
    @TableField("channel_name")
        private String channelName;

        /**
         * 渠道分类
         */
    @TableField("channel_category")
        private String channelCategory;

        /**
         * 备注
         */
    @TableField("remark")
        private String remark;

        /**
         * 状态（1-启用 2-停用）
         */
    @TableField("status")
        private Integer status;

        /**
         * 操作者
         */
    @TableField("operator")
        private String operator;

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
         * 是否有效（0-失效 1-有效）
         */
    @TableField("is_valid")
        private Integer isValid;


        }