package cn.edu.tfswufe.china.mapper;

import cn.edu.tfswufe.china.entity.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author 柒木Cat
 * @Date 2020/12/14 23:23
 * @Version 1.0
 */
@MapperScan("cn.edu.tfswufe.china.mapper")
@Mapper
@Repository
public interface IProvinceMapper {

    @Select("select * from province")
    List<Province> findAllProvince();
}
