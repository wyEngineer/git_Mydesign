package com.wy.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
//单选问题描述的实体类   还有多选，判断
public class AloneDescribe implements Serializable {

    private Integer id;
    /*问题id*/
    private Integer problemId;
    /*提出问题者*/
    private String username;
    /*问题者电话*/
    private String telephone;
    /*问题描述*/
    private String describe;
    /*问题模式*/
    private String problemModel;

    /*解决人*/
    private String handler;
    /*解决时间*/
    private Timestamp finishTime;
    /*是否完成*/
    private Integer isFinish;
    /*是否完成*/
    private String isFinishText;
    /*解决的内容*/
    private String answer;

}
