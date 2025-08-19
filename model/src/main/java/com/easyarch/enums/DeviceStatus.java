package com.easyarch.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.baomidou.mybatisplus.annotation.IEnum;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "设备状态枚举")
public enum DeviceStatus implements IEnum<String> {

    @Schema(description = "设备在线")
    ONLINE("ONLINE"),

    @Schema(description = "设备离线")
    OFFLINE("OFFLINE"),

    @Schema(description = "设备异常")
    ERROR("ERROR");

    /**
     * 存储到数据库中的值
     */
    @EnumValue
    private final String value;

    DeviceStatus(String value) {
        this.value = value;
    }

    /**
     * MyBatis-Plus 存库时用的值
     */
    @Override
    public String getValue() {
        return this.value;
    }

    /**
     * 返回给前端的 JSON 值
     */
    @JsonValue
    public String getJsonValue() {
        return this.value;
    }

    /**
     * 解析前端传来的 JSON 值
     * - 支持大小写
     * - 支持空字符串转 null
     */
    @JsonCreator
    public static DeviceStatus fromValue(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null; // 允许空字符串映射为 null
        }
        for (DeviceStatus status : DeviceStatus.values()) {
            if (status.value.equalsIgnoreCase(value.trim())) {
                return status;
            }
        }
        throw new IllegalArgumentException("无效的设备状态: " + value);
    }
}
