package com.wy.music.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/*多选的选项*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class ManyAnswer implements Serializable {
    //主键
    private Integer id;
    //多选的主键id
    private String  subjectId;
    //A选项
    private String textA;
    //B选项
    private String textB;
    //C选项
    private String textC;
    //D选项
    private String textD;
    //E选项
    private String textE;
}
