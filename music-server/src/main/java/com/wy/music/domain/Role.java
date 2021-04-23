package com.wy.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role implements Serializable {

    //角色主键id
    private Integer id;
    //角色名
    private String roleName;
}
