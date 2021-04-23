package com.wy.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

// 后台管理员的账户信息
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Admin  implements Serializable {
    private Integer id;
    private String number;
    private String name;
    private String username;
    private String password;
    //角色信息
    private Role  role;

    //用户头像
    private Image image;
}
