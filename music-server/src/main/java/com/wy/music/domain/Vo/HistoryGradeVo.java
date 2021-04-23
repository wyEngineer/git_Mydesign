package com.wy.music.domain.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.annotation.security.DenyAll;
import java.io.Serializable;

/*历史成绩扩展实体类*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class HistoryGradeVo implements Serializable {

    private String username;

    private String model;

    private Integer page;

    private Integer size;

    private String selectCondition;
}
