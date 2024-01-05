package com.org.clockshop.service.impl;

import com.org.clockshop.model.CustomUser;
import com.org.clockshop.model.Role;
import com.org.clockshop.model.User;
import com.org.clockshop.repository.RoleRepository;
import com.org.clockshop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByUserAccount(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
        List<Role> lstRole = roleRepository.getRoleByUserAccount(username);

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

        if (lstRole != null){
            for (Role role : lstRole){
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getRoleName());
                grantedAuthorities.add(authority);
            }
        }

        return new CustomUser(
                user.getUserAccount(),
                user.getUserPassword(),
                grantedAuthorities,
                user.getUserId(),
                user.getCreateTime(),
                user.isUserDeleted()
        );
    }
}
