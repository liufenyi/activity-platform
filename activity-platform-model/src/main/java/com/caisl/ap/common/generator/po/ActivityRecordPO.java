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
 * @describe 活动参与记录表实体类
 */
@Data
@TableName("activity_record")
public class ActivityRecordPO implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 主键
         */
                @TableId(value = "activity_record_id", type = IdType.ASSIGN_ID)
                private Long activityRecordId;

        /**
         * 用户ID
         */
    @TableField("customer_register_id")
        private String customerRegisterId;

        /**
         * 活动ID
         */
    @TableField("activity_id")
        private Long activityId;

        /**
         * 进度记录
         */
    @TableField("schedule")
        private String schedule;

        /**
         * 奖励属性
         */
    @TableField("reward")
        private String reward;

        /**
         * 是否有效
         */
    @TableField("status")
        private Integer status;

        /**
         * 扩展属性
         */
    @TableField("extend_field")
        private String extendField;

        /**
         * 备注
         */
    @TableField("remark")
        private String remark;

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
         * 是否有效
         */
    @TableField("is_valid")
        private Integer isValid;


        }