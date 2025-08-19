package com.easyarch.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Schema(description = "用户设备关联表")
@TableName("user_device_relation")
@AllArgsConstructor
@NoArgsConstructor
public class UserDeviceRelation {
    private static final long serialVersionUID = 1L;

    @Schema(description = "关联ID")
    private Integer id;

    @Schema(description = "用户ID")
    @TableField(value = "user_id")
    private Integer userId;
    @Schema(description = "设备ID")
    @TableField(value = "device_code")
    private String deviceCode;
    @Schema(description = "分配时间")
    @TableField(value = "assigned_at")
    private Date assignedAt;
    @Schema(description = "分配人ID")
    @TableField(value = "assigned_by")
    private Integer assignedBy;



}
