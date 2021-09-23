package com.chad.ademo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "javademo.zc_role")
public class Role implements Serializable {
	@TableId(value = "id", type = IdType.AUTO)
	private Integer id;
	
	@TableField(value = "role_name")
	private String roleName;
	
	private static final long serialVersionUID = 1L;
	
	public static final String COL_ID = "id";
	
	public static final String COL_ROLE_NAME = "role_name";
}