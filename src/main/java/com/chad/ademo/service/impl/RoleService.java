package com.chad.ademo.service.impl;

import java.util.List;
import com.chad.ademo.model.Role;
import com.baomidou.mybatisplus.extension.service.IService;
public interface RoleService extends IService<Role>{


    int updateBatch(List<Role> list);

    int updateBatchSelective(List<Role> list);

    int batchInsert(List<Role> list);

    int insertOrUpdate(Role record);

    int insertOrUpdateSelective(Role record);

}
