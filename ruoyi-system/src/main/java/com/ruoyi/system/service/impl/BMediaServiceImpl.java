package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BMediaMapper;
import com.ruoyi.system.domain.BMedia;
import com.ruoyi.system.service.IBMediaService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
@Service
public class BMediaServiceImpl implements IBMediaService 
{
    @Autowired
    private BMediaMapper bMediaMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public BMedia selectBMediaById(Long id)
    {
        return bMediaMapper.selectBMediaById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param bMedia 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<BMedia> selectBMediaList(BMedia bMedia)
    {
        return bMediaMapper.selectBMediaList(bMedia);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param bMedia 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBMedia(BMedia bMedia)
    {
        return bMediaMapper.insertBMedia(bMedia);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param bMedia 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBMedia(BMedia bMedia)
    {
        return bMediaMapper.updateBMedia(bMedia);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBMediaByIds(Long[] ids)
    {
        return bMediaMapper.deleteBMediaByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBMediaById(Long id)
    {
        return bMediaMapper.deleteBMediaById(id);
    }
}
