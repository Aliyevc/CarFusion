package com.example.carfusion.mapper;

import com.example.carfusion.model.dto.response.RoleDto;
import com.example.carfusion.model.entity.Role;

public class RoleMapper {

    public static Role toEntity(RoleDto roleDto) {

        Role role = new Role();
        role.setRole(roleDto.getRole());

        return role;
    }

    public static RoleDto toDto(Role role){

        RoleDto roleDto = new RoleDto();
        roleDto.setRole(role.getRole());

        return roleDto;
    }

}
