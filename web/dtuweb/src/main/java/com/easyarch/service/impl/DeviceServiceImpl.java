package com.easyarch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easyarch.entity.DeviceInfo;
import com.easyarch.mapper.device.DeviceMapper;
import com.easyarch.result.Result;
import com.easyarch.service.DeviceService;
import com.easyarch.vo.devicesInfo.DeviceDec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, DeviceInfo> implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;


    //根据条件获取设备列表
    @Override
    public Result<List<DeviceDec>> getDevicesByConditions(String userId, String type, String deviceName, String status) {
        List<DeviceDec> devicesByConditions = deviceMapper.getDevicesByConditions(userId, type, deviceName, status);

        return Result.ok(devicesByConditions);
    }

    //根据设备编号获取设备详情信息
    @Override
    public Result<DeviceDec> getDeviceInfo(String deviceCode) {
        DeviceDec deviceInfo = deviceMapper.selectByDeviceCode(deviceCode);
        System.out.println("查到的数据："+deviceInfo);

        return Result.ok(deviceInfo);
    }
}
