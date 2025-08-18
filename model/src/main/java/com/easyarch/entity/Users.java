package com.easyarch.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@TableName("users")
@Schema(description = "用户信息表")
@Data
public class Users  {
    private static final long serialVersionUID = 1L;
    @Schema(description = "自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "真实姓名")
    @TableField("real_name")
    private String realName;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "角色：管理员/操作员/查看者")
    private String role;

    @Schema(description = "创建时间")
    @TableField(value = "created_at",fill = FieldFill.INSERT)
    @JsonIgnore
    private Date createTime;
}
