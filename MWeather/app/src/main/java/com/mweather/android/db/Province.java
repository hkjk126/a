package com.mweather.android.db;

import org.litepal.crud.LitePalSupport;

public class Province extends LitePalSupport {
    /*
    * id                记录省的ID
    * provinceName      记录省的名字
    * provinceCode      记录省的代号
    * */
    private int id;
    private String provinceName;
    private int provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
