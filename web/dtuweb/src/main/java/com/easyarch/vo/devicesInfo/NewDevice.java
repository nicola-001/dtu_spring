package com.easyarch.vo.devicesInfo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "设备信息")
@NoArgsConstructor
@AllArgsConstructor
public class NewDevice extends Device {

    @Schema(description = "累计用水量")
    @TableField(value = "cumulative_usage")
    private String cumulativeUsage;

    @Schema(description = "协议类型")
    @TableField(value = "protocol_type")
    private String protocolType;

    @Schema(description = "设备描述")
    @TableField(value = "device_description")
    private String deviceDescription;

    @Schema(description = "波特率")
    @TableField("baud_rate")
    private Integer baudRate;

    @Schema(description = "数据位")
    @TableField("data_bits")
    private Integer dataBits;

    @Schema(description = "停止位")
    @TableField("stop_bits")
    private Integer stopBits;

    @Schema(description = "校验位")
    private String parity;

    @Schema(description = "IP地址")
    @TableField("ip_address")
    private String ipAddress;

    @Schema(description = "端口号")
    @TableField(value = "port")
    private Integer port;

    @Schema(description = "SIM卡号")
    @TableField(value = "sim_card_number")
    private String simCardNumber;

    @Schema(description = "设备类型")
    @TableField(value = "device_type")
    private String deviceType;

    @Schema(description = "负责人id")
    @TableField(value = "owner_id")
    private Integer ownerId;

    @Schema(description = "创建人ID")
    @TableField(value = "created_by")
    private Integer createdBy;
}
