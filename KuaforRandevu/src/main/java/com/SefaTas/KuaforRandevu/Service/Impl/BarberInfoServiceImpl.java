package com.SefaTas.KuaforRandevu.Service.Impl;

import com.SefaTas.KuaforRandevu.Dto.BarberInfoDto;
import com.SefaTas.KuaforRandevu.Entity.BarberInfo;
import com.SefaTas.KuaforRandevu.Exception.SourceNotFoundException;
import com.SefaTas.KuaforRandevu.Mapper.BarberInfoMapper;
import com.SefaTas.KuaforRandevu.Repository.BarberInfoRepository;
import com.SefaTas.KuaforRandevu.Service.BarberInfoService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class BarberInfoServiceImpl implements BarberInfoService {

    @Autowired
    private BarberInfoRepository barberInfoRepository;


    @Override
    public BarberInfoDto addBarberInfo(BarberInfoDto barberInfoDto) {
        BarberInfo barberInfo = BarberInfoMapper.mapToBarberInfo(barberInfoDto);
        BarberInfo registeredInfo = barberInfoRepository.save(barberInfo);
        return BarberInfoMapper.mapToBarberInfoDto(registeredInfo);
    }

    @Override
    public List<BarberInfoDto> findAllBarberInfo() {
        List<BarberInfo> barberInfos = barberInfoRepository.findAll();
        return barberInfos.stream().map((barberInfo -> BarberInfoMapper.mapToBarberInfoDto(barberInfo))).collect(Collectors.toList());
    }

    @Override
    public BarberInfoDto updateBarberInfo(Long barberInfoId, BarberInfoDto updatedBarberInfo) {
        BarberInfo barberInfo = barberInfoRepository.findById(barberInfoId)
                .orElseThrow(() -> new SourceNotFoundException("Girilen id ile ilişkili bir kayıt bulunanmadı. Id: " + barberInfoId));

        barberInfo.setDuration(barberInfo.getDuration());

        BarberInfo updateBarberInfoInDatabase = barberInfoRepository.save(barberInfo);

        return BarberInfoMapper.mapToBarberInfoDto(updateBarberInfoInDatabase);
    }
}
