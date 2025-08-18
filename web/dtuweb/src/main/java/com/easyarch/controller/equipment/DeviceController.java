package com.easyarch.controller.equipment;

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
//    @GetMapping("/meters")
//    @Operation(summary = "根据条件获取设备列表")
//    public Result<List<DeviceDec>> getAllDevice(
//            @RequestParam String userId,
//            @RequestParam(required = false) String type,
//            @RequestParam(required = false) String deviceName,
//            @RequestParam(required = false) String status) {
//
//    }
}
