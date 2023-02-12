package io.sample.memorise.hexachitecture.domains.coredomain.data;

import io.sample.memorise.hexachitecture.domains.coredomain.dto.car.model.TargetCar;

import java.util.List;

public interface RentalCarDataSearch {
    List<TargetCar> getOnlyNiceCarListInBudget(long budget);
    List<TargetCar> getEveryCarListInBudget(long budget);
}
