package by.yayauheny.mapstruct.controller;


import by.yayauheny.mapstruct.dto.UserCreateDto;
import by.yayauheny.mapstruct.dto.UserResponse;
import by.yayauheny.mapstruct.entity.User;
import by.yayauheny.mapstruct.mapper.UserMapper;
import by.yayauheny.mapstruct.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponseList = userMapper.toUserResponseList(users);
        return ResponseEntity.ok(userResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent()
                ? ResponseEntity.ok(userMapper.toUserResponse(user.get()))
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserCreateDto userCreateDto) {
        User user = userMapper.fromUserCreateDto(userCreateDto);
        User savedUser = userRepository.save(user);
        UserResponse userResponse = userMapper.toUserResponse(savedUser);
        return ResponseEntity.ok(userResponse);
    }
}
