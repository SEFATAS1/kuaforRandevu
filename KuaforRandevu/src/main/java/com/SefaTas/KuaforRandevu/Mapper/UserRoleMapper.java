package com.SefaTas.KuaforRandevu.Mapper;

import com.SefaTas.KuaforRandevu.Dto.UserRoleDto;
import com.SefaTas.KuaforRandevu.Entity.UserRole;

public class UserRoleMapper {
    public static UserRoleDto mapToUserRoleDto(UserRole userRole){
        return new UserRoleDto(
                userRole.getId(),
                userRole.getRoleName()
        );
    }

    public static UserRole mapToUserRole(UserRoleDto userRoleDto) {
        return new UserRole(
                userRoleDto.getId(),
                userRoleDto.getRoleName()
        );
    }
}
