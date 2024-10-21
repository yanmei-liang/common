package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BDmMapper;
import com.ruoyi.system.domain.BDm;
import com.ruoyi.system.service.IBDmService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
@Service
public class BDmServiceImpl implements IBDmService 
{
    @Autowired
    private BDmMapper bDmMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public BDm selectBDmById(Long id)
    {
        return bDmMapper.selectBDmById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param bDm 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<BDm> selectBDmList(BDm bDm)
    {
        return bDmMapper.selectBDmList(bDm);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param bDm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBDm(BDm bDm)
    {
        return bDmMapper.insertBDm(bDm);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param bDm 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBDm(BDm bDm)
    {
        return bDmMapper.updateBDm(bDm);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBDmByIds(Long[] ids)
    {
        return bDmMapper.deleteBDmByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBDmById(Long id)
    {
        return bDmMapper.deleteBDmById(id);
    }
}
