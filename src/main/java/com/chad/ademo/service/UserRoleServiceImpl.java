package com.chad.ademo.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chad.ademo.mapper.UserRoleMapper;
import java.util.List;
import com.chad.ademo.model.UserRole;
import com.chad.ademo.service.impl.UserRoleService;
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService{

    @Override
    public int updateBatch(List<UserRole> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int updateBatchSelective(List<UserRole> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<UserRole> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(UserRole record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(UserRole record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
