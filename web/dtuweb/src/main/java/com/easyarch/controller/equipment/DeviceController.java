package com.easyarch.controller.equipment;

import com.easyarch.login.LoginUser;
import com.easyarch.login.LoginUserHolder;
import com.easyarch.result.Result;
import com.easyarch.service.DeviceService;
import com.easyarch.vo.devicesInfo.DeviceDec;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dtu")
@Tag(name = "设备管理")
@Slf4j
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    //根据用户id获取所有的水表/水压表
    @GetMapping("/meters")
    @Operation(summary = "根据条件获取设备列表")
    public Result<List<DeviceDec>> getAllDevice(
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String deviceName,
            @RequestParam(required = false) String status) {
        //获取当前登录用户id
        LoginUser loginUser = LoginUserHolder.getLoginUser();
        System.out.println("id是:" + loginUser.getUserId());
        String userId = String.valueOf(loginUser.getUserId());
        Result<List<DeviceDec>> res = deviceService.getDevicesByConditions(userId, type, deviceName, status);
        return res;

    }

    //根据设设备信息获取设备详情信息
    @GetMapping("/devices")
    @Operation(summary = "根据设备信息获取设备详情")
    public Result<DeviceDec> getDeviceInfo(@RequestParam String deviceCode) {

        return null;
    }
}
