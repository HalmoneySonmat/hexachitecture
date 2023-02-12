package io.sample.memorise.hexachitecture.domains.coredomain.services.usecase;

import io.sample.memorise.hexachitecture.domains.coredomain.dto.car.model.TargetCar;
import io.sample.memorise.hexachitecture.domains.coredomain.dto.condition.BuyerCondition;

import java.util.List;

public interface CarSellingUseCase {
    TargetCar sellCar(BuyerCondition buyerCondition);
    List<TargetCar> sellBunchOfCar(BuyerCondition buyerCondition);
}
