package com.chad.ademo.service;

import java.util.List;
import com.chad.ademo.model.Users;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author 2319315514@qq.com
 * @date 2021/09/24 09:37:21
 */
public interface UsersService extends IService<Users>{


    int updateBatch(List<Users> list);

    int updateBatchSelective(List<Users> list);

    int batchInsert(List<Users> list);

    int insertOrUpdate(Users record);

    int insertOrUpdateSelective(Users record);

}
