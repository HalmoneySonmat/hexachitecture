package io.sample.memorise.hexachitecture.adaptors.presentation.service.dto;

import io.sample.memorise.hexachitecture.domains.coredomain.dto.car.model.TargetCar;

public class ApiResponseDto {
    //TODO 아이디어 고갈, 좋은이름 생각나면 바꾸기
    private String message;
    private String code;

    //TODO domain 종속적인 DTO를 사용해도 되지만, 되도록이면 필요한 정보로 치환해 응답할 것
    //TODO 필요한 정보를 규격화 해 VO로 만들어 응답할 것
    private TargetCar targetCar;

}
