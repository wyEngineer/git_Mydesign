package com.wy.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/*多选实体类*/
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ManyExamination implements Serializable {

    /*主键id*/
    private Integer id;
    /*多选的题目*/
    private String ManyText;
    /*多选的答案*/
    private String ManyAnswerChoose;
    /*定义一个空集合，传给前端多选的v-model,将选择的数据，存到这里面。不然选择某一行内的数据，全局都会变*/
    private String[] choose =new String[0];
    /*定义一个答案集合,方便前端校验*/
    private String[] manyAnswers;
    /*多选的答案选项，共五个*/
    ManyAnswer manyAnswer;
}
