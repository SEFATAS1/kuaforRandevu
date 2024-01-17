package com.SefaTas.KuaforRandevu.Mapper;

import com.SefaTas.KuaforRandevu.Dto.BarberInfoDto;
import com.SefaTas.KuaforRandevu.Entity.BarberInfo;

public class BarberInfoMapper {
    public static BarberInfoDto mapToBarberInfoDto(BarberInfo barberInfo){
        return new BarberInfoDto(
                barberInfo.getId(),
                barberInfo.getUserId(),
                barberInfo.getDuration()
        );
    }

    public static BarberInfo mapToBarberInfo(BarberInfoDto barberInfoDto){
        return  new BarberInfo(
                barberInfoDto.getId(),
                barberInfoDto.getUserId(),
                barberInfoDto.getDuration()
        );
    }
}
