package com.chad.aopdemo.security;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.chad.aopdemo.mapper.UsersMapper;
import com.chad.aopdemo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private UsersMapper usersMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LambdaQueryWrapper<Users> wrapper = new LambdaQueryWrapper<>();
		wrapper.eq(Users::getUsername, username);
		Users users = usersMapper.selectOne(wrapper);
		if (users == null) {
			throw new UsernameNotFoundException("用户不存在!");
		}
		List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
		String password = new BCryptPasswordEncoder().encode(users.getPassword());
		return new User(users.getUsername(), password, auths);
	}
}
