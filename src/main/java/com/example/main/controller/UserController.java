package com.example.main.controller;

import com.example.main.dto.request.UserRequestDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @PostMapping()
    public String addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        return "User added";
    }

    @PutMapping("/{userID}")
    public String updateUser(@PathVariable int userID, @RequestBody UserRequestDTO userDTO) {
        return "User updated";
    }

    @PatchMapping("/{userID}")
    public String changeStatus(@PathVariable int userID, @RequestParam(required = false) boolean status) {
        return "User status changed";
    }

    @DeleteMapping("/{userID}")
    public String deleteUser(@PathVariable int userID) {
        return "User deleted";
    }

    @GetMapping("/{userID}")
    public UserRequestDTO getUser(@PathVariable int userID) {
        return new UserRequestDTO("", "", "", "", null, null);
    }

    @GetMapping()
    public List<UserRequestDTO> getAllUsers(@RequestParam(required = false) String email, @RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return new ArrayList<UserRequestDTO>();
    }
}
