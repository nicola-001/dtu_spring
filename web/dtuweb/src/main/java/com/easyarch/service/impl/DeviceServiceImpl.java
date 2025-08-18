package com.easyarch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.easyarch.entity.DeviceInfo;
import com.easyarch.mapper.device.DeviceMapper;
import com.easyarch.service.DeviceService;
import com.easyarch.vo.devicesInfo.DeviceDec;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, DeviceInfo> implements DeviceService {

    @Autowired
    private DeviceMapper deviceMapper;


}
