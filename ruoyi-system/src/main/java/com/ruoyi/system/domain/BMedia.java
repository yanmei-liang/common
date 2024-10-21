package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 【请填写功能名称】对象 b_media
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public class BMedia extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 类型(1电子丛书，2电子图集，3故事影音，4地名文化) */
    @Excel(name = "类型(1电子丛书，2电子图集，3故事影音，4地名文化)")
    private String type;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 归属区镇 */
    @Excel(name = "归属区镇")
    private String area;

    /** 主图/封面 */
    @Excel(name = "主图/封面")
    private String mainimg;

    /** 简介 */
    @Excel(name = "简介")
    private String content;

    /** 是否主页展示 */
    @Excel(name = "是否主页展示")
    private Long isshow;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createuer;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    @Override
    public Date getCreateTime() {
        return createtime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createtime = createTime;
    }

    /** 是否删除(0，1) */
    @Excel(name = "是否删除(0，1)")
    private Long isdel;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setAuthor(String author) 
    {
        this.author = author;
    }

    public String getAuthor() 
    {
        return author;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setMainimg(String mainimg) 
    {
        this.mainimg = mainimg;
    }

    public String getMainimg() 
    {
        return mainimg;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setIsshow(Long isshow) 
    {
        this.isshow = isshow;
    }

    public Long getIsshow() 
    {
        return isshow;
    }
    public void setCreateuer(String createuer) 
    {
        this.createuer = createuer;
    }

    public String getCreateuer() 
    {
        return createuer;
    }
    public void setIsdel(Long isdel) 
    {
        this.isdel = isdel;
    }

    public Long getIsdel() 
    {
        return isdel;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("name", getName())
            .append("author", getAuthor())
            .append("area", getArea())
            .append("mainimg", getMainimg())
            .append("content", getContent())
            .append("isshow", getIsshow())
            .append("createuer", getCreateuer())
            .append("createtime", getCreateTime())
            .append("isdel", getIsdel())
            .toString();
    }
}
