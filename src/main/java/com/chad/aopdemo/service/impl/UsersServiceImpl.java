package com.chad.aopdemo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.chad.aopdemo.mapper.UsersMapper;
import com.chad.aopdemo.model.Users;
import com.chad.aopdemo.service.UsersService;
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService{

    @Override
    public int updateBatch(List<Users> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int updateBatchSelective(List<Users> list) {
        return baseMapper.updateBatchSelective(list);
    }
    @Override
    public int batchInsert(List<Users> list) {
        return baseMapper.batchInsert(list);
    }
    @Override
    public int insertOrUpdate(Users record) {
        return baseMapper.insertOrUpdate(record);
    }
    @Override
    public int insertOrUpdateSelective(Users record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}
