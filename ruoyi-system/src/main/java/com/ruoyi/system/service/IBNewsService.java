package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BNews;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public interface IBNewsService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public BNews selectBNewsById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param bNews 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<BNews> selectBNewsList(BNews bNews);

    /**
     * 新增【请填写功能名称】
     * 
     * @param bNews 【请填写功能名称】
     * @return 结果
     */
    public int insertBNews(BNews bNews);

    /**
     * 修改【请填写功能名称】
     * 
     * @param bNews 【请填写功能名称】
     * @return 结果
     */
    public int updateBNews(BNews bNews);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteBNewsByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBNewsById(Long id);
}
