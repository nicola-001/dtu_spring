package com.easyarch.controller.equipment;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.easyarch.login.LoginUser;
import com.easyarch.login.LoginUserHolder;
import com.easyarch.result.Result;
import com.easyarch.service.DeviceService;
import com.easyarch.vo.devicesInfo.DeviceDec;
import com.easyarch.vo.devicesInfo.NewDevice;
import com.easyarch.vo.devicesInfo.UpdateDevice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Result<IPage<DeviceDec>> getAllDevice(
            @RequestParam String current,
            @RequestParam String size,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String deviceName,
            @RequestParam(required = false) String status) {
        //获取当前登录用户id
        LoginUser loginUser = LoginUserHolder.getLoginUser();
        System.out.println("current:" + current + "size:" + size);
        String userId = String.valueOf(loginUser.getUserId());
        Page<DeviceDec> deviceDecPage = new Page<>(Long.valueOf(current), Long.valueOf(size));
        IPage<DeviceDec> res = deviceService.getDevicesByConditions(deviceDecPage, userId, type, deviceName, status);
        return Result.ok(res);

    }

    //根据设备编号获取设备详情信息
    @GetMapping("/devices")
    @Operation(summary = "根据设备编号获取设备详情")
    public Result<DeviceDec> getDeviceInfo(@RequestParam String deviceCode) {

        Result<DeviceDec> res = deviceService.getDeviceInfo(deviceCode);
        return res;
    }

    //新增水表/水压表
    @PostMapping("/devices")
    @Operation(summary = "新增设备")
    public Result addDeviceInfo(@RequestBody NewDevice newDevice) {
        deviceService.addDeviceInfo(newDevice);
        return Result.ok();
    }

    //根据设备编号更新设备信息
    @PutMapping("/devices")
    @Operation(summary = "更新设备信息")
    public Result updateDeviceInfo(@RequestBody UpdateDevice updateDevice) {
        deviceService.updateDeviceInfo(updateDevice);
        return Result.ok();
    }

    //根据设备编号删除设备信息
    @DeleteMapping("/devices/{deviceCode}")
    @Operation(summary = "删除设备信息")
    public Result deleteDeviceInfo(@PathVariable String deviceCode) {
        deviceService.removeByDeviceCode(deviceCode);
        return Result.ok();
    }
}
