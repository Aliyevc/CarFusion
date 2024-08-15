package com.example.carfusion.mapper;

import com.example.carfusion.model.dto.response.UserDto;
import com.example.carfusion.model.entity.User;

public class UserMapper {

    public static UserDto toDto(User user){
        if (user == null){
            return null;
        }
        UserDto userDto = new UserDto();

        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        userDto.setPhone(user.getPhone());
        userDto.setEmail(user.getEmail());



        return userDto;
    }

    public static User toEntity(UserDto userDto){
        if (userDto == null){
            return null;
        }
        User user = new User();

        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setPhone(userDto.getPhone());
        user.setEmail(userDto.getEmail());


        return user;
    }
}