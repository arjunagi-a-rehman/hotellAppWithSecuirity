package com.Arjunagi.HotelRoomSecuirity.service;

import com.Arjunagi.HotelRoomSecuirity.model.Users;
import com.Arjunagi.HotelRoomSecuirity.repo.IUsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {
    private IUsersRepo usersRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public UsersServices(IUsersRepo usersRepo){
        this.usersRepo=usersRepo;
    }

    public void addUser(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        usersRepo.save(users);
    }
}
