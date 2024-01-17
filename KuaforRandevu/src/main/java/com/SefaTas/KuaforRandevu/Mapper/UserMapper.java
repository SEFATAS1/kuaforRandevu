package com.SefaTas.KuaforRandevu.Mapper;

import com.SefaTas.KuaforRandevu.Dto.UserDto;
import com.SefaTas.KuaforRandevu.Entity.User;

public class UserMapper{
    public static UserDto mapToUserDto(User user){
        return new UserDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getPhone(),
                user.getEmail(),
                user.getPassword(),
                user.getUserRoleId()
        );
    }

    public static User mapToUser(UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getPhone(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getUserRoleId()
        );
    }
}
