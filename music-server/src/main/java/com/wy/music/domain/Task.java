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
public class Task implements Serializable {

    private Integer id;

    /*制定任务用户名*/
    private String username;
    /*制定任务时间*/
    private Timestamp taskCreate;
    /*任务状态*/
    private Integer taskStatus;
    /*任务状态*/
    private boolean taskStatusFlag;
    /*任务描述*/
    private String taskDescribe;

}
