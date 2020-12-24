package cn.edu.tfswufe.china.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 柒木Cat
 * @Date 2020/12/14 23:16
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class County {

    private Long id;

    private Long cityId;

    private String countyName;

    private String weatherId;
}
