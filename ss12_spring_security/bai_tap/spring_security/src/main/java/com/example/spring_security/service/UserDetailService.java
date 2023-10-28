package com.example.spring_security.service;

import com.example.spring_security.entity.AppUser;
import com.example.spring_security.entity.UserRole;
import com.example.spring_security.repository.IAppUserRepository;
import com.example.spring_security.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private IAppUserRepository appUserRepository;
    @Autowired
    private IUserRoleRepository userRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        AppUser appUser = this.appUserRepository.findByUserName(userName);
        if (appUser == null){
            System.out.println("Not Found" + userName);
            throw new UsernameNotFoundException("User" + userName + "Not found in the database");
        }
        System.out.println("User: " + appUser);
        List<UserRole> userRoleList = this.userRoleRepository.findByAppUser(appUser);
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        if (userRoleList != null){
            for (UserRole userRole : userRoleList){
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                grantedAuthorityList.add(grantedAuthority);
            }
        }
        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), appUser.getEncrytedPassword(),
                grantedAuthorityList);
        return userDetails;
    }
}
