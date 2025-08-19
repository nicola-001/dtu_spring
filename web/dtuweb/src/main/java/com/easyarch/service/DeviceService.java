package com.easyarch.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.easyarch.entity.DeviceInfo;
import com.easyarch.result.Result;
import com.easyarch.vo.devicesInfo.DeviceDec;
import com.easyarch.vo.devicesInfo.NewDevice;
import com.easyarch.vo.devicesInfo.UpdateDevice;

import java.util.List;

public interface DeviceService extends IService<DeviceInfo> {
    Result<List<DeviceDec>> getDevicesByConditions(String userId, String type, String deviceName, String status);

    Result<DeviceDec> getDeviceInfo(String deviceCode);

    void addDeviceInfo(NewDevice newDevice);

    void updateDeviceInfo(UpdateDevice updateDevice);

    void removeByDeviceCode(String deviceCode);
}
