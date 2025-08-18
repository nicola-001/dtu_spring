package com.easyarch.vo.devicesInfo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "新增设备信息")
public class UpdateDevice extends Device {

    @Schema(description = "设备描述")
    @TableField(value = "device_description")
    private String deviceDescription;

    @Schema(description = "波特率")
    @TableField(value = "baud_rate")
    private String baudRate;

    @Schema(description = "数据位")
    @TableField(value = "data_bits")
    private String dataBits;

    @Schema(description = "停止位")
    @TableField(value = "stop_bits")
    private String stopBits;

    @Schema(description = "校验位")
    private String parity;

    @Schema(description = "设备类型")
    @TableField(value = "protocol_type")
    private String protocolType;
}
