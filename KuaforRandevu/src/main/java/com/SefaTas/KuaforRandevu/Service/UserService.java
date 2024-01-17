package com.SefaTas.KuaforRandevu.Service;

import com.SefaTas.KuaforRandevu.Dto.UserDto;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {
    UserDto addUser(UserDto userDto);
    UserDto findWithId(Long userId);
    List<UserDto> findAllUsers();
    UserDto updateUser(Long userId, UserDto updatedUsers);
    void deleteUser(Long userId);
}
