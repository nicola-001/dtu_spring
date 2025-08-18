package com.easyarch.mapper.device;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easyarch.entity.DeviceInfo;
import com.easyarch.vo.devicesInfo.DeviceDec;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceMapper extends BaseMapper<DeviceInfo> {

    List<DeviceDec> getDevicesByConditions(String userId, String type, String deviceName, String status);

    DeviceDec selectByDeviceCode(String deviceCode);
}
