package com.example.carfusion.service;

import com.example.carfusion.mapper.UserMapper;
import com.example.carfusion.model.dto.request.CreateUserRequest;
import com.example.carfusion.model.dto.response.UserDto;
import com.example.carfusion.model.entity.User;
import com.example.carfusion.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UserService {

    UserRepository userRepository;

    protected User createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setName(createUserRequest.getName());
        user.setSurname(createUserRequest.getSurname());
        user.setEmail(createUserRequest.getEmail());
        user.setPhone(createUserRequest.getPhoneNumber());
        user.setPassword(createUserRequest.getPassword());
        return userRepository.save(user);
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
