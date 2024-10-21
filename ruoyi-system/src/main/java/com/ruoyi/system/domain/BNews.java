package com.ruoyi.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 【请填写功能名称】对象 b_news
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public class BNews extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 来源 */
    @Excel(name = "来源")
    private String resource;

    /** 来源地址 */
    @Excel(name = "来源地址")
    private String resourceurl;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 是否展示 */
    @Excel(name = "是否展示")
    private String isshow;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    /** 发布人 */
    @Excel(name = "发布人")
    private String createuer;

    /** 是否删除(0,1) */
    @Excel(name = "是否删除(0,1)")
    private Long isdel;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setResource(String resource) 
    {
        this.resource = resource;
    }

    public String getResource() 
    {
        return resource;
    }
    public void setResourceurl(String resourceurl) 
    {
        this.resourceurl = resourceurl;
    }

    public String getResourceurl() 
    {
        return resourceurl;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setIsshow(String isshow) 
    {
        this.isshow = isshow;
    }

    public String getIsshow() 
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
            .append("title", getTitle())
            .append("resource", getResource())
            .append("resourceurl", getResourceurl())
            .append("content", getContent())
            .append("isshow", getIsshow())
            .append("createuer", getCreateuer())
            .append("createtime", getCreatetime())
            .append("isdel", getIsdel())
            .toString();
    }
}
