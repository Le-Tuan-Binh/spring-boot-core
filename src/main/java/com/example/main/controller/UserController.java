package com.example.main.controller;

import com.example.main.dto.request.UserRequestDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {
    @PostMapping()
    public String addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        return "User added";
    }

    @PutMapping("/{userID}")
    public String updateUser(@Min(1) @PathVariable int userID, @RequestBody UserRequestDTO userDTO) {
        return "User updated";
    }

    @PatchMapping("/{userID}")
    public String changeStatus(@Min(1) @PathVariable int userID, @RequestParam(required = false) boolean status) {
        return "User status changed";
    }

    @DeleteMapping("/{userID}")
    public String deleteUser(@Min(1) @PathVariable int userID) {
        return "User deleted";
    }

    @GetMapping("/{userID}")
    public UserRequestDTO getUser(@Min(1) @PathVariable int userID) {
        return new UserRequestDTO("", "", "", "", null, null, null, null, null);
    }

    @GetMapping()
    public List<UserRequestDTO> getAllUsers(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return new ArrayList<UserRequestDTO>();
    }
}
