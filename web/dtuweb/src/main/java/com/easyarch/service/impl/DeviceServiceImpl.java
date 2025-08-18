package com.easyarch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easyarch.entity.DeviceInfo;
import com.easyarch.mapper.device.DeviceMapper;
import com.easyarch.result.Result;
import com.easyarch.service.DeviceService;
import com.easyarch.vo.devicesInfo.Device;
import com.easyarch.vo.devicesInfo.DeviceDec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, DeviceInfo> implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;


    @Override
    public Result<List<DeviceDec>> getDevicesByConditions(String userId, String type, String deviceName, String status) {
        List<DeviceDec> devicesByConditions = deviceMapper.getDevicesByConditions(userId, type, deviceName, status);

        return Result.ok(devicesByConditions);
    }
}
