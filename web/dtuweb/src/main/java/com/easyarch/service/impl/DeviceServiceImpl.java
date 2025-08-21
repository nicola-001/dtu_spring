package com.easyarch.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easyarch.entity.DeviceInfo;
import com.easyarch.entity.UserDeviceRelation;
import com.easyarch.login.LoginUserHolder;
import com.easyarch.mapper.device.DeviceMapper;
import com.easyarch.result.Result;
import com.easyarch.service.DeviceService;
import com.easyarch.vo.devicesInfo.DeviceDec;
import com.easyarch.vo.devicesInfo.NewDevice;
import com.easyarch.vo.devicesInfo.UpdateDevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Slf4j
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, DeviceInfo> implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;


    //根据条件获取设备列表
    @Override
    public IPage<DeviceDec> getDevicesByConditions(Page<DeviceDec> page, String userId, String type, String deviceName, String status) {
        IPage<DeviceDec> devicesByConditions = deviceMapper.selectPageVo(page, userId, type, deviceName, status);
        System.out.println("查到的数据：" + devicesByConditions);
        return devicesByConditions;
    }

    //根据设备编号获取设备详情信息
    @Override
    public Result<DeviceDec> getDeviceInfo(String deviceCode) {
        DeviceDec deviceInfo = deviceMapper.selectByDeviceCode(deviceCode);
        System.out.println("查到的数据：" + deviceInfo);

        return Result.ok(deviceInfo);
    }

    //添加设备
    @Override
    @Transactional
    public void addDeviceInfo(NewDevice device) {
        // 自动填充 createdBy
        device.setCreatedBy(LoginUserHolder.getLoginUser().getUserId().intValue());
        // 插入设备信息
        deviceMapper.insertDeviceInfo(device);
        // 插入设备连接信息
        deviceMapper.insertDeviceConnection(device);
        // 绑定设备与用户关系表
        UserDeviceRelation relation = new UserDeviceRelation();
        relation.setUserId(LoginUserHolder.getLoginUser().getUserId().intValue());
        relation.setDeviceCode(device.getDeviceCode());
        relation.setAssignedBy(LoginUserHolder.getLoginUser().getUserId().intValue());       // 自己分配给自己

        deviceMapper.insertUserDeviceRelation(relation);   // 必须调用 insert 方法

    }

    //更新设备信息
    @Override
    @Transactional
    public void updateDeviceInfo(UpdateDevice updateDevice) {
        deviceMapper.updateDeviceInfo(updateDevice);
        deviceMapper.updateDeviceConnection(updateDevice);
    }

    //根据设备编号删除设备信息
    @Override
    public void removeByDeviceCode(String deviceCode) {
        deviceMapper.removeByDeviceCode(deviceCode);
    }


}
