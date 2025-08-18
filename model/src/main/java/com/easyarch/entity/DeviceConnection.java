package com.easyarch.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "设备连接信息")
@TableName("device_connection")
public class DeviceConnection extends BaseEntity {
    @Schema(description = "波特率，默认9600")
    @TableField("baud_rate")
    private Integer baudRate;

    @Schema(description = "数据位，默认8")
    @TableField("data_bits")
    private Integer dataBits;

    @Schema(description = "停止位，默认1")
    @TableField("stop_bits")
    private Integer stopBits;

    @Schema(description = "校验位：N=无, E=偶, O=奇，默认N")
    @TableField("parity")
    private String parity;

    @Schema(description = "协议类型，默认MODBUS")
    @TableField("protocol_type")
    private String protocolType;

    @Schema(description = "IP地址")
    @TableField("ip_address")
    private String ipAddress;

    @Schema(description = "端口号")
    @TableField("`port`")
    private Integer port;

    @Schema(description = "SIM卡号")
    @TableField("sim_card_number")
    private String simCardNumber;
}
