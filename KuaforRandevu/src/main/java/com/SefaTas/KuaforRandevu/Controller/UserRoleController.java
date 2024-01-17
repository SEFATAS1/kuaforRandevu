package com.SefaTas.KuaforRandevu.Controller;

import com.SefaTas.KuaforRandevu.Dto.UserRoleDto;
import com.SefaTas.KuaforRandevu.Service.UserRoleService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping("/api/v1/userroles")
    public ResponseEntity<List<UserRoleDto>> findAllUserRoles() {
        List<UserRoleDto> userRoleDtoList = userRoleService.findAllUserRoles();
        return ResponseEntity.ok(userRoleDtoList);
    }
}
