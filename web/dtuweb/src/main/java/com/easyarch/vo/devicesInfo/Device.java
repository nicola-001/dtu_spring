package com.easyarch.vo.devicesInfo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.easyarch.entity.BaseEntity;
import com.easyarch.enums.DeviceStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "设备信息")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device extends BaseEntity {

    @Schema(description = "设备编号")
    @TableField(value = "device_code")
    private String deviceCode;

    @Schema(description = "设备名称")
    @TableField(value = "device_name")
    private String deviceName;

    @Schema(description = "在线状态")
    private DeviceStatus status;


    @Schema(description = "安装位置")
    @TableField(value = "installation_location")
    private String installationLocation;
}
