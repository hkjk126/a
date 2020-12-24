package cn.edu.tfswufe.china.controller;

import cn.edu.tfswufe.china.entity.vo.Response;
import cn.edu.tfswufe.china.entity.vo.WeatherResponse;
import cn.edu.tfswufe.china.service.CityService;
import cn.edu.tfswufe.china.service.CountyService;
import cn.edu.tfswufe.china.service.ProvinceService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 柒木Cat
 * @Date 2020/12/11 17:38
 * @Version 1.0
 */
@RestController
@RequestMapping("/api")
public class APIController {

    @Resource
    private ProvinceService provinceService;

    @Resource
    private CityService cityService;

    @Resource
    private CountyService countyService;


    /**
     * 用于获取中国的所有省的json数据
     * @return 所有省的json数组
     */
    @RequestMapping("/china")
    public Response[] getProvinces() {

        Response[] provinceResponses = provinceService.getProvinceResponses();

        return provinceResponses;
    }

    /**
     * 用于获取特定省的所有市的json数据
     * @param cityId city的id
     * @return 特定省的所有市的json数组
     */
    @RequestMapping("/china/{cityId}")
    public Response[] getCities(@PathVariable("cityId") Long cityId) {

        Response[] cityResponses =  cityService.getCityResponses(cityId);

        return cityResponses;
    }

    /**
     * 用于获取特定市的所有县的json数据
     * @param cityId city的id
     * @param cityCode city的编号
     * @return 特定市的所有县的json数组
     */
    @RequestMapping("/china/{cityId}/{cityCode}")
    public WeatherResponse[] getCounties(@PathVariable("cityId") Long cityId,
                                         @PathVariable("cityCode") Long cityCode) {

        Long city_Id = cityService.getCityIdByCityCode(cityId);

        WeatherResponse[] weatherResponses = countyService.getCountyResponses(cityCode);

        return weatherResponses;
    }

}
