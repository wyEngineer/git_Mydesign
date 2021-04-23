package com.wy.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
//历史成绩实体类
public class HistoryGrade implements Serializable {
    //主键id
    private Integer id;
    //考试人用户名
    private String username;
    //考试时间
    private Timestamp exaimTime;
    //考试类型
    private String exaimModel;
    //是否合格
    private String exaimIsQualified;
    //考试分数
    private Integer exaimScore;

    /*用户数据*/
    private Admin admin;
}
