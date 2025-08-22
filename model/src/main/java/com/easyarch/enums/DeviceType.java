package com.easyarch.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "设备类型枚举")
public enum DeviceType implements IEnum<String> {
    @Schema(description = "水表")
    WATER("WATER"),
    @Schema(description = "水压表")
    PRESSURE("PRESSURE");

    @EnumValue
    private final String value;

    DeviceType(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return this.value;
    }


}
