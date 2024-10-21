package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 b_message
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public class BMessage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 留言内容 */
    @Excel(name = "留言内容")
    private String content;

    /** 留言用户ip地址 */
    @Excel(name = "留言用户ip地址")
    private String ipaddress;

    /** 状态(留言待审核，审核待回复，回复待发布) */
    @Excel(name = "状态(留言待审核，审核待回复，回复待发布)")
    private Long status;

    /** 回复部门 */
    @Excel(name = "回复部门")
    private String recivedepart;

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

    /** 回复内容 */
    @Excel(name = "回复内容")
    private String reccontent;

    /** 回复时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "回复时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date recivetime;

    /** 是否公开展示 */
    @Excel(name = "是否公开展示")
    private Long ispublic;



    /** 是否删除(0,1) */
    @Excel(name = "是否删除(0,1)")
    private Long isdel;

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
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setIpaddress(String ipaddress) 
    {
        this.ipaddress = ipaddress;
    }

    public String getIpaddress() 
    {
        return ipaddress;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setRecivedepart(String recivedepart) 
    {
        this.recivedepart = recivedepart;
    }

    public String getRecivedepart() 
    {
        return recivedepart;
    }
    public void setReccontent(String reccontent) 
    {
        this.reccontent = reccontent;
    }

    public String getReccontent() 
    {
        return reccontent;
    }
    public void setRecivetime(Date recivetime) 
    {
        this.recivetime = recivetime;
    }

    public Date getRecivetime() 
    {
        return recivetime;
    }
    public void setIspublic(Long ispublic) 
    {
        this.ispublic = ispublic;
    }

    public Long getIspublic() 
    {
        return ispublic;
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
            .append("content", getContent())
            .append("ipaddress", getIpaddress())
            .append("status", getStatus())
            .append("recivedepart", getRecivedepart())
            .append("reccontent", getReccontent())
            .append("recivetime", getRecivetime())
            .append("ispublic", getIspublic())
            .append("createtime", getCreateTime())
            .append("isdel", getIsdel())
            .toString();
    }
}
