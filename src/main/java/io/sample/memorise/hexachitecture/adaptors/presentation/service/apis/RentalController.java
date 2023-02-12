package io.sample.memorise.hexachitecture.adaptors.presentation.service.apis;

import io.sample.memorise.hexachitecture.adaptors.presentation.service.commands.ApiCommand;
import io.sample.memorise.hexachitecture.adaptors.presentation.service.factories.RentalServiceFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RentalController {

    RentalServiceFactory rentalServiceFactory;

    @PostMapping("/rental/car")
    public String searchRentalCar(String requestBody) {
        ApiCommand command = rentalServiceFactory.getRentCarCommand();
        command.setRequestDto(requestBody);
        command.execute();
        return command.getResponse();
    }
}
