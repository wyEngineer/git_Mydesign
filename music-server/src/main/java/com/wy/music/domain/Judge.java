package com.wy.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class Judge implements Serializable {
    //主键
    private Integer id;
    //题目
    private String text;
    //答案，1代表正确，0代表错误
    private Integer answer;
    //答案 中文
    private String answerText;
}
