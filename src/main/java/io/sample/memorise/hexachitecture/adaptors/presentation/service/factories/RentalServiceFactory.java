package io.sample.memorise.hexachitecture.adaptors.presentation.service.factories;

import io.sample.memorise.hexachitecture.adaptors.presentation.service.commands.ApiCommand;
import io.sample.memorise.hexachitecture.adaptors.presentation.service.commands.CarRentalCommand;
import io.sample.memorise.hexachitecture.domains.coredomain.services.usecase.CarRentalUseCase;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RentalServiceFactory {


    private CarRentalUseCase carRentalUseCase;


    //TODO 여기선 version등을 받아서 다른 command를 리턴할 수 있다
    public ApiCommand getRentCarCommand() {
        return new CarRentalCommand(carRentalUseCase);
    }
}
