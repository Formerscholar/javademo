package com.chad.ademo.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chad.ademo.mapper.RoleMapper;
import com.chad.ademo.mapper.UserRoleMapper;
import com.chad.ademo.mapper.UsersMapper;
import com.chad.ademo.model.Role;
import com.chad.ademo.model.UserRole;
import com.chad.ademo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UsersMapper usersMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(Users::getUsername, username);
		Users users = usersMapper.selectOne(wrapper);
		if (users == null) {
			throw new UsernameNotFoundException("用户不存在!");
		}
		LambdaQueryWrapper<UserRole> queryWrapper = new LambdaQueryWrapper<>();
		queryWrapper.eq(UserRole::getId, users.getId());
		List<UserRole> selectList = userRoleMapper.selectList(queryWrapper);
		List<Object> collect = selectList.stream().map(UserRole::getRoleId).collect(Collectors.toList());
		LambdaQueryWrapper<Role> lambdaQueryWrapper = new LambdaQueryWrapper<>();
		lambdaQueryWrapper.in(Role::getId, collect);
		List<Role> roles = roleMapper.selectList(lambdaQueryWrapper);
		List<String> stringList = roles.stream().map(Role::getRoleName).collect(Collectors.toList());
		String join = String.join(",", stringList);
		List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList(join);
		return new User(users.getUsername(), users.getPassword(), auths);
	}
}
