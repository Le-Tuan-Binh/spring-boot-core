package com.example.main.controller;

import com.example.main.dto.request.UserRequestDTO;
import com.example.main.dto.response.ResponseSuccess;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Operation(summary = "", description = "", responses = {
            @ApiResponse(responseCode = "201",
                         description = "User added successfully",
                         content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            examples = @ExampleObject(name = "", summary = "", value = """
                                                    {
                                                        "status": 201,
                                                        "message": "User added successfully",
                                                        "data": 1
                                                    }
                                                    """)))
    })
    @PostMapping()
    public ResponseSuccess addUser(@Valid @RequestBody UserRequestDTO userDTO) {
        return new ResponseSuccess(HttpStatus.CREATED, "User added successfully", 1);
    }

    @PutMapping("/{userID}")
    public ResponseSuccess updateUser(@Min(1) @PathVariable int userID, @RequestBody UserRequestDTO userDTO) {
        return new ResponseSuccess(HttpStatus.ACCEPTED, "User updated successfully");
    }

    @PatchMapping("/{userID}")
    public ResponseSuccess changeStatus(@Min(1) @PathVariable int userID, @RequestParam(required = false) boolean status) {
        return new ResponseSuccess(HttpStatus.ACCEPTED, "User status changed");
    }

    @DeleteMapping("/{userID}")
    public ResponseSuccess deleteUser(@Min(1) @PathVariable int userID) {
        return new ResponseSuccess(HttpStatus.NO_CONTENT, "User deleted successfully");
    }

    @GetMapping("/{userID}")
    public ResponseSuccess getUser(@Min(1) @PathVariable int userID) {
        return new ResponseSuccess(HttpStatus.OK, "User found successfully", null);
    }

    @GetMapping()
    public ResponseSuccess getAllUsers(@RequestParam(defaultValue = "0") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return new ResponseSuccess(HttpStatus.OK, "User found successfully", null);
    }
}
