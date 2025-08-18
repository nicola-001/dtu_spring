package com.easyarch.vo.devicesInfo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "设备信息")
public class NewDevice extends  Device{

    @Schema(description = "累计用水量")
    @TableField(value = "cumulative_usage")
    private String cumulativeUsage;

    @Schema(description = "协议类型")
    @TableField(value = "protocol_type")
    private String protocolType;

}
