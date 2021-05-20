package com.caisl.ap.common.generator.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
 * @describe 活动配置表实体类
 */
@Data
@TableName("activity_config")
public class ActivityConfigPO implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 主键
         */
                @TableId(value = "activity_config_id", type = IdType.ASSIGN_ID)
                private Long activityConfigId;

        /**
         * 活动编号
         */
    @TableField("activity_code")
        private String activityCode;

        /**
         * 活动标题
         */
    @TableField("activity_title")
        private String activityTitle;

        /**
         * 活动类型
         */
    @TableField("activity_type")
        private Integer activityType;

        /**
         * 活动创建人
         */
    @TableField("creator")
        private String creator;

        /**
         * 活动操作人
         */
    @TableField("operator")
        private String operator;

        /**
         * 环境 dev pre publish daily
         */
    @TableField("env")
        private String env;

        /**
         * 活动发布人
         */
    @TableField("publisher")
        private String publisher;

        /**
         * 活动状态（1-待发布 2-进行中 3-已暂停 4-已终止 5-已过期）
         */
    @TableField("status")
        private Integer status;

        /**
         * 开始时间
         */
    @TableField("start_time")
        private Date startTime;

        /**
         * 结束时间
         */
    @TableField("end_time")
        private Date endTime;

        /**
         * 发布时间
         */
    @TableField("publish_time")
        private Date publishTime;

        /**
         * 创建时间
         */
                @TableField(value = "create_time", fill = FieldFill.INSERT)
        private Date createTime;

        /**
         * 更新时间
         */
    @TableField("op_time")
        private Date opTime;

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
         * 活动的一些描述
         */
    @TableField("description")
        private String description;

        /**
         * 活动备注
         */
    @TableField("remark")
        private String remark;

        /**
         * 扩展字段列表，json串
         */
    @TableField("extend_field")
        private String extendField;


        }