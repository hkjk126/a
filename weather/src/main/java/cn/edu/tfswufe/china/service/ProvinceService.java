package cn.edu.tfswufe.china.service;

import cn.edu.tfswufe.china.entity.vo.Response;
import cn.edu.tfswufe.china.entity.Province;
import cn.edu.tfswufe.china.mapper.IProvinceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author 柒木Cat
 * @Date 2020/12/14 23:25
 * @Version 1.0
 */
@Service
public class ProvinceService {

    @Resource
    private IProvinceMapper provinceMapper;

    /**
     * 用于处理获取所有省的json数组的逻辑
     * @return 所有省的json数组
     */
    public Response[] getProvinceResponses() {
        List<Province> provinceList = provinceMapper.findAllProvince();
        Response[] provinceResponse = new Response[provinceList.size()];
        for (int i = 0; i < provinceList.size(); i++) {
            provinceResponse[i] = Response.builder().id(provinceList.get(i).getId())
                    .name(provinceList.get(i).getProvinceName()).build();
        }
        return provinceResponse;
    }
}
