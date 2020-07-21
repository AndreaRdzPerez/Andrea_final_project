package com.ironhack.edgeservice.service;


import com.ironhack.edgeservice.client.UserClient;
import com.ironhack.edgeservice.model.User;
import com.ironhack.edgeservice.security.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserClient userClient;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userClient.findByUsername(username);
    
    if (user == null)
      throw new UsernameNotFoundException("Invalid username/password combination.");
    
    return new CustomSecurityUser(user);
  }


  
}
