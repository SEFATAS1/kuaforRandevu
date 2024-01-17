package com.SefaTas.KuaforRandevu.Service.Impl;

import com.SefaTas.KuaforRandevu.Dto.UserRoleDto;
import com.SefaTas.KuaforRandevu.Entity.UserRole;
import com.SefaTas.KuaforRandevu.Mapper.UserRoleMapper;
import com.SefaTas.KuaforRandevu.Repository.UserRoleRepository;
import com.SefaTas.KuaforRandevu.Service.UserRoleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service("UserRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<UserRoleDto> findAllUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoles.stream().map((userRole -> UserRoleMapper.mapToUserRoleDto(userRole))).collect(Collectors.toList());
    }
}
