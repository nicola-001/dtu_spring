package com.easyarch.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;


@Data
@Schema(description = "设备信息")
@TableName("device_info")
public class DeviceInfo extends BaseEntity {

    @Schema(description = "设备编号(唯一)")
    @TableField("device_code")
    private String deviceCode;

    @Schema(description = "设备名称")
    @TableField("device_name")
    private String deviceName;

    @Schema(description = "设备描述")
    @TableField("device_description")
    private String deviceDesc;

    @Schema(description = "设备类型：WATER=水表，PRESSURE=水压")
    @TableField("device_type")
    private String deviceType;

    @Schema(description = "设备状态")
    @TableField("status")
    private String status;

    @Schema(description = "当前读数")
    @TableField("current_reading")
    private BigDecimal currentReading;

    @Schema(description = "累计用水量")
    @TableField("cumulative_usage")
    private BigDecimal cumulativeUsage;

    @Schema(description = "计量单位")
    @TableField("unit")
    private String unit;

    @Schema(description = "安装位置")
    @TableField("installation_location")
    private String installationLocation;

    @Schema(description = "初始安装读数")
    @TableField("initial_reading")
    private BigDecimal initialReading;

    @Schema(description = "设备负责人ID")
    @TableField("owner_id")
    private Integer ownerId;

    @Schema(description = "创建人ID")
    @TableField("created_by")
    private Integer createdBy;

    @Schema(description = "更新人ID")
    @TableField("updated_by")
    private Integer updatedBy;

}
