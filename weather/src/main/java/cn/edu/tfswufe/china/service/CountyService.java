package cn.edu.tfswufe.china.service;

import cn.edu.tfswufe.china.entity.County;
import cn.edu.tfswufe.china.entity.vo.WeatherResponse;
import cn.edu.tfswufe.china.mapper.ICountyMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 柒木Cat
 * @Date 2020/12/14 23:25
 * @Version 1.0
 */
@Service
public class CountyService {

    @Resource
    private ICountyMapper countyMapper;

    /**
     * 用于处理获取特定市的所有县的json数组的逻辑
     * @param cityId 特定市的id
     * @return 特定市的所有县的json数组
     */
    public WeatherResponse[] getCountyResponses(Long cityId) {
        List<County> countyList = countyMapper.findAllCountyByCityId(cityId);
        WeatherResponse[] weatherResponses = new WeatherResponse[countyList.size()];
        for (int i = 0; i < countyList.size(); i++) {
            weatherResponses[i] = WeatherResponse.builder().id(countyList.get(i).getId())
                    .name(countyList.get(i).getCountyName()).weather_id(countyList.get(i).getWeatherId()).build();
        }
        return weatherResponses;
    }
}
