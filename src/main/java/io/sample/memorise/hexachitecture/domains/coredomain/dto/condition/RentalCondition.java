package io.sample.memorise.hexachitecture.domains.coredomain.dto.condition;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalCondition {
    private int retryCount;
    private long hopefulPriceRange;
    private long budget;
    private boolean isOkToRentalUsedCar;

}
