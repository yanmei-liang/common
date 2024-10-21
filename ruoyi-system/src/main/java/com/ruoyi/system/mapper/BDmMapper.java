package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BDm;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public interface BDmMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public BDm selectBDmById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param bDm 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<BDm> selectBDmList(BDm bDm);

    /**
     * 新增【请填写功能名称】
     * 
     * @param bDm 【请填写功能名称】
     * @return 结果
     */
    public int insertBDm(BDm bDm);

    /**
     * 修改【请填写功能名称】
     * 
     * @param bDm 【请填写功能名称】
     * @return 结果
     */
    public int updateBDm(BDm bDm);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBDmById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBDmByIds(Long[] ids);
}
