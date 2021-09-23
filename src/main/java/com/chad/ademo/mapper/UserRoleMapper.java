package com.chad.ademo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chad.ademo.model.UserRole;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRoleMapper extends BaseMapper<UserRole> {
    int updateBatch(List<UserRole> list);

    int updateBatchSelective(List<UserRole> list);

    int batchInsert(@Param("list") List<UserRole> list);

    int insertOrUpdate(UserRole record);

    int insertOrUpdateSelective(UserRole record);
}