package com.chad.ademo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "javademo.zc_user_role")
public class UserRole implements Serializable {
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	
	@TableField(value = "user_id")
	private Integer userId;
	
	@TableField(value = "role_id")
	private Integer roleId;
	
	private static final long serialVersionUID = 1L;
	
	public static final String COL_ID = "id";
	
	public static final String COL_USER_ID = "user_id";
	
	public static final String COL_ROLE_ID = "role_id";
}