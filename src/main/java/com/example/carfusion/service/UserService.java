package com.example.carfusion.service;

import com.example.carfusion.model.dto.request.CreateUserRequest;
import com.example.carfusion.model.dto.response.UserDto;
import com.example.carfusion.mapper.UserMapper;
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

    public UserDto createUser(CreateUserRequest createUserRequest) {

        User user = new User();
        user.setName(createUserRequest.getName());
        user.setSurname(createUserRequest.getSurname());
        user.setEmail(createUserRequest.getEmail());
        user.setPhone(createUserRequest.getPhone());
        user.setPassword(createUserRequest.getPassword());
        userRepository.save(user);

        return UserMapper.toDto(user);
    }

    public String getNameById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        return UserMapper.toDto(user).getName();
    }

    public String getSurnameById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        return UserMapper.toDto(user).getSurname();
    }

    public String getPhoneById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        return UserMapper.toDto(user).getPhone();
    }

    public String getEmailById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        return UserMapper.toDto(user).getEmail();
    }



    public void deleteUser(Long id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
        user.setIsActive(false);
        userRepository.save(user);
    }

    public UserDto updateUser(Long id, UserDto updatedUserProfileDTO) {

        return userRepository.findById(id).map(existingUser -> {

                    existingUser.setName(updatedUserProfileDTO.getName());
                    existingUser.setSurname(updatedUserProfileDTO.getSurname());
                    existingUser.setPhone(updatedUserProfileDTO.getPhone());
                    existingUser.setEmail(updatedUserProfileDTO.getEmail());
                    userRepository.save(existingUser);
                    return UserMapper.toDto(existingUser);
                })
                .orElseThrow(RuntimeException::new);
    }
}
