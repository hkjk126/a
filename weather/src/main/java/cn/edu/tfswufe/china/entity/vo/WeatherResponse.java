package cn.edu.tfswufe.china.entity.vo;

import lombok.Builder;
import lombok.Data;

/**
 * @Author 柒木Cat
 * @Date 2020/12/14 23:20
 * @Version 1.0
 */
@Data
@Builder
public class WeatherResponse {

    private Long id;

    private String name;

    private String weather_id;
}
