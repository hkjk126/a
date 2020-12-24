package cn.edu.tfswufe.china.mapper;

import cn.edu.tfswufe.china.entity.City;
import cn.edu.tfswufe.china.entity.County;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author 柒木Cat
 * @Date 2020/12/14 23:22
 * @Version 1.0
 */
@Mapper
@Repository
public interface ICountyMapper {

    @Select("select * from county where cityId = #{cityId}")
    List<County> findAllCountyByCityId(Long cityId);
}
