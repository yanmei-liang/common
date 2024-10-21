package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BMessageMapper;
import com.ruoyi.system.domain.BMessage;
import com.ruoyi.system.service.IBMessageService;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-10-21
 */
@Service
public class BMessageServiceImpl implements IBMessageService 
{
    @Autowired
    private BMessageMapper bMessageMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param id 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public BMessage selectBMessageById(Long id)
    {
        return bMessageMapper.selectBMessageById(id);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param bMessage 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<BMessage> selectBMessageList(BMessage bMessage)
    {
        return bMessageMapper.selectBMessageList(bMessage);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param bMessage 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertBMessage(BMessage bMessage)
    {
        return bMessageMapper.insertBMessage(bMessage);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param bMessage 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updateBMessage(BMessage bMessage)
    {
        return bMessageMapper.updateBMessage(bMessage);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param ids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBMessageByIds(Long[] ids)
    {
        return bMessageMapper.deleteBMessageByIds(ids);
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param id 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deleteBMessageById(Long id)
    {
        return bMessageMapper.deleteBMessageById(id);
    }
}
