package com.chad.ademo.service.impl;

import java.util.List;
import com.chad.ademo.model.UserRole;
import com.baomidou.mybatisplus.extension.service.IService;
public interface UserRoleService extends IService<UserRole>{


    int updateBatch(List<UserRole> list);

    int updateBatchSelective(List<UserRole> list);

    int batchInsert(List<UserRole> list);

    int insertOrUpdate(UserRole record);

    int insertOrUpdateSelective(UserRole record);

}
