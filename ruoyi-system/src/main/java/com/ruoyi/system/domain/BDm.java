package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 b_dm
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public class BDm extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 类型(特色地名：ts;历史地名:ls;乡村著名:xc;便民服务:bm;区划:qh;搜索:ss) */
    @Excel(name = "类型(特色地名：ts;历史地名:ls;乡村著名:xc;便民服务:bm;区划:qh;搜索:ss)")
    private String dicType;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 简介 */
    @Excel(name = "简介")
    private String content;

    /** 图片地址 */
    @Excel(name = "图片地址")
    private String imgurl;

    /** 坐标集合 */
    @Excel(name = "坐标集合")
    private String pointarr;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDicType(String dicType) 
    {
        this.dicType = dicType;
    }

    public String getDicType() 
    {
        return dicType;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setImgurl(String imgurl) 
    {
        this.imgurl = imgurl;
    }

    public String getImgurl() 
    {
        return imgurl;
    }
    public void setPointarr(String pointarr) 
    {
        this.pointarr = pointarr;
    }

    public String getPointarr() 
    {
        return pointarr;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("dicType", getDicType())
            .append("name", getName())
            .append("address", getAddress())
            .append("content", getContent())
            .append("imgurl", getImgurl())
            .append("pointarr", getPointarr())
            .toString();
    }
}
