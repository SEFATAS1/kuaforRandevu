package com.SefaTas.KuaforRandevu.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceDto {
    private Long id;
    private String serviceName;
    private Integer duration;
    private Integer price;
}
