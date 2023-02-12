package io.sample.memorise.hexachitecture.adaptors.presentation.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiRequestDto {
    //TODO 아이디어 고갈, 좋은이름 생각나면 바꾸기

    private long budget;

    private int retryCount;

    private boolean okToRentalUsedCar;
}
