package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.BMedia;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public interface IBMediaService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public BMedia selectBMediaById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param bMedia 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<BMedia> selectBMediaList(BMedia bMedia);

    /**
     * 新增【请填写功能名称】
     * 
     * @param bMedia 【请填写功能名称】
     * @return 结果
     */
    public int insertBMedia(BMedia bMedia);

    /**
     * 修改【请填写功能名称】
     * 
     * @param bMedia 【请填写功能名称】
     * @return 结果
     */
    public int updateBMedia(BMedia bMedia);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deleteBMediaByIds(Long[] ids);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBMediaById(Long id);
}
