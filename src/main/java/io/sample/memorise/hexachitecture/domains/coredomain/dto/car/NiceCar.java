package io.sample.memorise.hexachitecture.domains.coredomain.dto.car;

import io.sample.memorise.hexachitecture.domains.coredomain.dto.car.model.TargetCar;

public class NiceCar implements TargetCar {
    private boolean isUsed;
    private long rentalPrice;
    private int discountRate;

    public NiceCar(boolean isUsed, long rentalPrice, int discountRate) {
        this.isUsed = isUsed;
        this.rentalPrice = rentalPrice;
        this.discountRate = discountRate;
    }

    @Override
    public boolean isUsed() {
        return isUsed;
    }

    @Override
    public long getRentalPrice() {
        return rentalPrice;
    }

    @Override
    public int getDiscountRate() {
        return discountRate;
    }

}
