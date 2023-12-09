package com.Arjunagi.HotelRoomSecuirity.Controller;

import com.Arjunagi.HotelRoomSecuirity.model.Users;
import com.Arjunagi.HotelRoomSecuirity.service.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    private UsersServices usersServices;

    @PostMapping("/user/register")
    public String addUser(@RequestBody Users users){
        usersServices.addUser(users);
        return "added successfully";
    }

}

