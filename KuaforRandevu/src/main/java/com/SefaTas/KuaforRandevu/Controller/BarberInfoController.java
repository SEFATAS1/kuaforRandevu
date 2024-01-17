package com.SefaTas.KuaforRandevu.Controller;

import com.SefaTas.KuaforRandevu.Dto.BarberInfoDto;
import com.SefaTas.KuaforRandevu.Service.BarberInfoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@RestController
public class BarberInfoController {

    @Autowired
    private BarberInfoService barberInfoService;

    @PostMapping("/api/v1/barberinfos")
    public ResponseEntity<BarberInfoDto> addBarberInfo(@RequestBody BarberInfoDto barberInfoDto){
        BarberInfoDto registeredInfo = barberInfoService.addBarberInfo(barberInfoDto);
        return new ResponseEntity<>(registeredInfo, HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/barberinfos")
    public ResponseEntity<List<BarberInfoDto>> findAllBarberInfo(){
        List<BarberInfoDto> barberInfoDtoList = barberInfoService.findAllBarberInfo();
        return ResponseEntity.ok(barberInfoDtoList);
    }

    @PutMapping("/api/v1/barberinfos/{Id}")
    public ResponseEntity<BarberInfoDto> updateBarberInfo(@PathVariable("Id") Long barberInfoId, @RequestBody BarberInfoDto currentBarberInfoDto){
        BarberInfoDto barberInfoDto = barberInfoService.updateBarberInfo(barberInfoId, currentBarberInfoDto);
        return ResponseEntity.ok(barberInfoDto);
    }
}
