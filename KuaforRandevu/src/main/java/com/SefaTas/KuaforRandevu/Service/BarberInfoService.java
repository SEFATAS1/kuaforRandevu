package com.SefaTas.KuaforRandevu.Service;

import com.SefaTas.KuaforRandevu.Dto.BarberInfoDto;

import java.util.List;

public interface BarberInfoService {
    BarberInfoDto addBarberInfo(BarberInfoDto barberInfoDto);
    List<BarberInfoDto> findAllBarberInfo();
    BarberInfoDto updateBarberInfo(Long barberInfoId, BarberInfoDto updatedBarberInfo);
}
