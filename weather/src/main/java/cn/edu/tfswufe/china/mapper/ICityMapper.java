package cn.edu.tfswufe.china.mapper;

import cn.edu.tfswufe.china.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 柒木Cat
 * @Date 2020/12/14 23:21
 * @Version 1.0
 */
@Mapper
@Repository
public interface ICityMapper {

    @Select("select * from city where provinceId = #{provinceId}")
    List<City> findAllCityByProvinceId(Long provinceId);

    @Select("select id from city where cityCode = #{cityCode}")
    Long findCityIdByCityCode(Long cityCode);
}
