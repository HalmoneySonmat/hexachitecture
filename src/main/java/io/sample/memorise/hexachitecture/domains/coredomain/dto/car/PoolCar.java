package io.sample.memorise.hexachitecture.domains.coredomain.dto.car;

import io.sample.memorise.hexachitecture.domains.coredomain.dto.car.model.TargetCar;

public class PoolCar implements TargetCar {
    private boolean isUsed;
    private long rentalPrice;
    private int discountRate;
    private long defaultDiscountPrice;

    public PoolCar(boolean isUsed, long rentalPrice, int discountRate, long defaultDiscountPrice) {
        this.isUsed = isUsed;
        this.rentalPrice = rentalPrice;
        this.discountRate = discountRate;
        this.defaultDiscountPrice = defaultDiscountPrice;
    }

    @Override
    public boolean isUsed() {
        return isUsed;
    }

    @Override
    public long getRentalPrice() {
        return rentalPrice - defaultDiscountPrice;
    }

    @Override
    public int getDiscountRate() {
        return discountRate;
    }

}
