package io.sample.memorise.hexachitecture.adaptors.presentation.service.commands;

import io.sample.memorise.hexachitecture.adaptors.presentation.service.dto.ApiRequestDto;
import io.sample.memorise.hexachitecture.adaptors.presentation.service.dto.ApiResponseDto;
import io.sample.memorise.hexachitecture.domains.coredomain.dto.car.model.TargetCar;
import io.sample.memorise.hexachitecture.domains.coredomain.dto.condition.RentalCondition;
import io.sample.memorise.hexachitecture.domains.coredomain.exceptions.NoSearchTargetCar;
import io.sample.memorise.hexachitecture.domains.coredomain.services.usecase.CarRentalUseCase;
import io.sample.memorise.hexachitecture.server.util.GsonUtil;

public class CarRentalCommand implements ApiCommand{

    CarRentalUseCase carRentalUseCase;

    ApiRequestDto apiRequestDto;

    ApiResponseDto apiResponseDto;

    public CarRentalCommand(CarRentalUseCase carRentalUseCase){
        this.carRentalUseCase = carRentalUseCase;
    }

    @Override
    public void setRequestDto(String requestBody) {
        //TODO 필수 값 확인

        //DTO로 변환
        this.apiRequestDto = GsonUtil.gson.fromJson(requestBody, ApiRequestDto.class);
    }

    @Override
    public void execute() {

        RentalCondition rentalCondition = new RentalCondition();
        rentalCondition.setBudget(apiRequestDto.getBudget());
        rentalCondition.setRetryCount(apiRequestDto.getRetryCount());
        rentalCondition.setOkToRentalUsedCar(apiRequestDto.isOkToRentalUsedCar());

        long maximum = getPriceRange(rentalCondition);
        rentalCondition.setHopefulPriceRange(maximum);

        TargetCar targetCar = null;
        try {
            targetCar = this.carRentalUseCase.rentalCar(rentalCondition);
        } catch (NoSearchTargetCar e) {
            //TODO 예외처리 ExceptionHandler로 빼기
            e.printStackTrace();
        }

        this.apiResponseDto = new ApiResponseDto();
        //TODO UseCase에서 받은 결과 데이터를 응답 DTO로 변환
    }

    private long getPriceRange(RentalCondition rentalCondition) {
        //TODO 요청 조건에 따라 계산한 최대값
        return 10000;
    }

    @Override
    public String getResponse() {
        return GsonUtil.gson.toJson(this.apiResponseDto);
    }
}
