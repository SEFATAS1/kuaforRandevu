package com.SefaTas.KuaforRandevu.Controller;

import com.SefaTas.KuaforRandevu.Dto.UserDto;
import com.SefaTas.KuaforRandevu.Entity.User;
import com.SefaTas.KuaforRandevu.Service.UserService;
import com.SefaTas.KuaforRandevu.Shared.GenericMessage;
import com.SefaTas.KuaforRandevu.Shared.Messages;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/api/v1/users")
    GenericMessage addUser(@Valid @RequestBody UserDto userDto){
        userService.addUser(userDto);
        String message = Messages.getMessageForLocale("KuaforRandevu.create.user.success.message", LocaleContextHolder.getLocale());
        return new GenericMessage(message);
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<List<UserDto>> findAllUsers(){
        List<UserDto> userDtoList = userService.findAllUsers();
        return ResponseEntity.ok(userDtoList);
    }

}
