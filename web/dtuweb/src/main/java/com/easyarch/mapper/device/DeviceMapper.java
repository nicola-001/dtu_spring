package com.easyarch.mapper.device;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.easyarch.entity.DeviceInfo;
import com.easyarch.entity.UserDeviceRelation;
import com.easyarch.result.Result;
import com.easyarch.vo.devicesInfo.DeviceDec;
import com.easyarch.vo.devicesInfo.NewDevice;
import com.easyarch.vo.devicesInfo.UpdateDevice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeviceMapper extends BaseMapper<DeviceInfo> {

    List<DeviceDec> getDevicesByConditions(String userId, String type, String deviceName, String status);

    DeviceDec selectByDeviceCode(String deviceCode);


    void insertDeviceInfo(NewDevice device);

    void insertDeviceConnection(NewDevice device);

    void insertUserDeviceRelation( UserDeviceRelation relation);

    void updateDeviceInfo(UpdateDevice updateDevice);

    void updateDeviceConnection(UpdateDevice updateDevice);

    void removeByDeviceCode(String deviceCode);
}
