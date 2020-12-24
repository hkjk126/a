package cn.edu.tfswufe.china.service;

import cn.edu.tfswufe.china.entity.City;
import cn.edu.tfswufe.china.entity.vo.Response;
import cn.edu.tfswufe.china.mapper.ICityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 柒木Cat
 * @Date 2020/12/14 23:23
 * @Version 1.0
 */
@Service
public class CityService {

    @Resource
    private ICityMapper cityMapper;

    /**
     * 用于处理获取特定省的所有市的json数组
     * @param provinceId 特定省的id
     * @return 特定省的所有市的json数组
     */
    public Response[] getCityResponses(Long provinceId) {
        List<City> cityList = cityMapper.findAllCityByProvinceId(provinceId);
        Response[] cityResponse = new Response[cityList.size()];
        for (int i = 0; i < cityList.size(); i++) {
            cityResponse[i] = Response.builder().id(cityList.get(i).getCityCode())
                    .name(cityList.get(i).getCityName()).build();
        }
        return cityResponse;
    }

    /**
     * 用于处理获取特定市的id的逻辑
     * @param cityCode 特定市的编号
     * @return 特定市的id
     */
    public Long getCityIdByCityCode(Long cityCode) {

        Long cityId = cityMapper.findCityIdByCityCode(cityCode);

        return cityId;
    }
}

