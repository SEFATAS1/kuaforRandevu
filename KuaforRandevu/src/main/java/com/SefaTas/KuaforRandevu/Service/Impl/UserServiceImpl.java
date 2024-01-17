package com.SefaTas.KuaforRandevu.Service.Impl;

import com.SefaTas.KuaforRandevu.Dto.UserDto;
import com.SefaTas.KuaforRandevu.Entity.User;
import com.SefaTas.KuaforRandevu.Exception.NotUniqueEmailException;
import com.SefaTas.KuaforRandevu.Mapper.UserMapper;
import com.SefaTas.KuaforRandevu.Repository.UserRepository;
import com.SefaTas.KuaforRandevu.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto addUser(UserDto userDto) {
        try {
            User user = UserMapper.mapToUser(userDto);
            User registereduser = userRepository.save(user);
            return UserMapper.mapToUserDto(registereduser);
        } catch (DataIntegrityViolationException ex) {
            throw new NotUniqueEmailException();
        }
    }

    @Override
    public UserDto findWithId(Long userId) {
        return null;
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user -> UserMapper.mapToUserDto(user))).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUsers) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
