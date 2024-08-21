package com.example.carfusion.service;

import com.example.carfusion.config.SecurityConfig;
import com.example.carfusion.exception.UserNotFoundException;
import com.example.carfusion.model.dto.request.CreateUserRequest;
import com.example.carfusion.model.dto.response.UserDto;
import com.example.carfusion.mapper.UserMapper;
import com.example.carfusion.model.dto.update.UpdateUserRequest;
import com.example.carfusion.model.entity.User;
import com.example.carfusion.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserService {


    UserRepository userRepository;
    SecurityConfig securityConfig;
    RoleService roleService;

    public UserDto createUser(CreateUserRequest createUserRequest) {

        User user = new User();
        user.setName(createUserRequest.getName());
        user.setSurname(createUserRequest.getSurname());
        user.setEmail(createUserRequest.getEmail());
        user.setPhone(createUserRequest.getPhone());
        user.setPassword(securityConfig.passwordEncoder().encode(createUserRequest.getPassword()));
        user.setRole(roleService.getByRole(createUserRequest.getRole()));
        userRepository.save(user);

        return UserMapper.toDto(user);
    }


    protected String getNameById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        return UserMapper.toDto(user).getName();
    }

    protected String getSurnameById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        return UserMapper.toDto(user).getSurname();
    }

    protected String getPhoneById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        return UserMapper.toDto(user).getPhone();
    }

    protected String getEmailById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));
        return UserMapper.toDto(user).getEmail();
    }



    public void deleteUser(Long id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Not Found"));

        if (!user.getIsActive()) {
            throw new UserNotFoundException("User is not active");
        }
        else {
            user.setIsActive(false);
        }
        userRepository.save(user);
    }

    public UserDto updateUser(UpdateUserRequest updateUserRequest) {

        User user = userRepository.findByEmail(updateUserRequest.getEmail()).orElseThrow(RuntimeException::new);
        user.setPassword(updateUserRequest.getPassword());
        userRepository.save(user);

        return UserMapper.toDto(user);
    }
}
