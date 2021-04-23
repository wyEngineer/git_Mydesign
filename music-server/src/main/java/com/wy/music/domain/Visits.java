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
public class Visits implements Serializable {

    private Integer id;
    //用户点击量
    private Integer visitNumber;
    //用户点赞量
    private Integer fabulousNumber;
}
