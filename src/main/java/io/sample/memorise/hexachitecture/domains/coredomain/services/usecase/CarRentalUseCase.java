package io.sample.memorise.hexachitecture.domains.coredomain.services.usecase;

import io.sample.memorise.hexachitecture.domains.coredomain.dto.car.model.TargetCar;
import io.sample.memorise.hexachitecture.domains.coredomain.dto.condition.RentalCondition;
import io.sample.memorise.hexachitecture.domains.coredomain.exceptions.NoSearchTargetCar;

import java.util.List;

public interface CarRentalUseCase {
    TargetCar rentalCar(RentalCondition rentalCondition) throws NoSearchTargetCar;
    List<TargetCar> rentalBunchOfCar(RentalCondition rentalCondition);
}
