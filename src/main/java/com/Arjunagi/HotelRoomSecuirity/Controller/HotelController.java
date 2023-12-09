package com.Arjunagi.HotelRoomSecuirity.Controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {
    @GetMapping("/")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello security");
    }
    @GetMapping("/room/rooms")
    public ResponseEntity<String> getAll(){
        return ResponseEntity.ok("rooms");
    }
    @GetMapping("/room/comeras")
    @PreAuthorize(value = "hasRole('ADMIN')")
    public String getCammeras(){
        return "1";
    }
    @GetMapping("/admin/porn")
    public String getPorn(){
        return "mia";
    }
}
