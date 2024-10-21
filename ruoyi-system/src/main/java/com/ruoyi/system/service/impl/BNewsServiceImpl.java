package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BNewsMapper;
import com.ruoyi.system.domain.BNews;
import com.ruoyi.system.service.IBNewsService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
@Service
public class BNewsServiceImpl implements IBNewsService 
{
    @Autowired
    private BNewsMapper bNewsMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public BNews selectBNewsById(Long id)
    {
        return bNewsMapper.selectBNewsById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param bNews 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<BNews> selectBNewsList(BNews bNews)
    {
        return bNewsMapper.selectBNewsList(bNews);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param bNews 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBNews(BNews bNews)
    {
        return bNewsMapper.insertBNews(bNews);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param bNews 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBNews(BNews bNews)
    {
        return bNewsMapper.updateBNews(bNews);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBNewsByIds(Long[] ids)
    {
        return bNewsMapper.deleteBNewsByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBNewsById(Long id)
    {
        return bNewsMapper.deleteBNewsById(id);
    }
}
