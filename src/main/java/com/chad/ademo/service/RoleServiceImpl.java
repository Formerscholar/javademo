package com.chad.ademo.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.chad.ademo.mapper.RoleMapper;
import com.chad.ademo.model.Role;
import com.chad.ademo.service.impl.RoleService;
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService{

    @Override
    public int updateBatch(List<Role> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int updateBatchSelective(List<Role> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<Role> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(Role record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(Role record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
