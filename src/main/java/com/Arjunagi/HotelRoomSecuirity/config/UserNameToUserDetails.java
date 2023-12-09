package com.Arjunagi.HotelRoomSecuirity.config;

import com.Arjunagi.HotelRoomSecuirity.model.Users;
import com.Arjunagi.HotelRoomSecuirity.repo.IUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserNameToUserDetails implements UserDetailsService {
    @Autowired
    private IUsersRepo usersRepo;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users users=usersRepo.findByEmail(email).orElseThrow();
        return new UserToUserDetails(users);
    }
}
