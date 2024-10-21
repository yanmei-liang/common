package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.BMessage;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
public interface BMessageMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public BMessage selectBMessageById(Long id);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param bMessage 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<BMessage> selectBMessageList(BMessage bMessage);

    /**
     * 新增【请填写功能名称】
     * 
     * @param bMessage 【请填写功能名称】
     * @return 结果
     */
    public int insertBMessage(BMessage bMessage);

    /**
     * 修改【请填写功能名称】
     * 
     * @param bMessage 【请填写功能名称】
     * @return 结果
     */
    public int updateBMessage(BMessage bMessage);

    /**
     * 删除【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    public int deleteBMessageById(Long id);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBMessageByIds(Long[] ids);
}
