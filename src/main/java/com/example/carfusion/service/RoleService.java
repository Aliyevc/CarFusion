package com.example.carfusion.service;

import com.example.carfusion.exception.RoleNotFoundException;
import com.example.carfusion.mapper.RoleMapper;
import com.example.carfusion.model.dto.request.CreateRoleRequest;
import com.example.carfusion.model.dto.response.RoleDto;
import com.example.carfusion.model.entity.Role;
import com.example.carfusion.repository.RoleRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class RoleService {

    RoleRepository roleRepository;

    public RoleDto createRole(CreateRoleRequest createRoleRequest) {

        Role role = new Role();
        role.setRole(createRoleRequest.getRole());

        return RoleMapper.toDto(role);

    }

    public String getRoleById(Long id) {

        Role role = roleRepository.findById(id).
                orElseThrow(() -> new RoleNotFoundException("Role Not Found"));
        return RoleMapper.toDto(role).getRole();
    }

    public void deleteRole(Long id) {

        Role role = roleRepository.findById(id).
                orElseThrow(() -> new RoleNotFoundException("Role Not Found"));
        role.setIsActive(false);
        roleRepository.save(role);
    }

    public RoleDto updateRole(Long id, RoleDto roleDto) {

        return roleRepository.findById(id).map(existingRole -> {

            existingRole.setRole(roleDto.getRole());
            return RoleMapper.toDto(existingRole);

        }).orElseThrow(() -> new RoleNotFoundException("Role Not Found"));
    }

    protected Role getByRole(String role) {

        return roleRepository.findByRole(role).
                orElseThrow(() -> new RoleNotFoundException("Role Not Found"));
    }


}
