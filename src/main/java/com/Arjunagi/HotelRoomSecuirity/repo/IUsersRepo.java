package com.Arjunagi.HotelRoomSecuirity.repo;


import com.Arjunagi.HotelRoomSecuirity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUsersRepo extends JpaRepository<Users,Integer> {
    Optional<Users> findByEmail(String email);
}
