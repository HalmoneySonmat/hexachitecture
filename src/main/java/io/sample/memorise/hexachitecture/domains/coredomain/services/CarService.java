package io.sample.memorise.hexachitecture.domains.coredomain.services;

import io.sample.memorise.hexachitecture.domains.coredomain.data.RentalCarDataSearch;
import io.sample.memorise.hexachitecture.domains.coredomain.dto.car.model.TargetCar;
import io.sample.memorise.hexachitecture.domains.coredomain.dto.condition.BuyerCondition;
import io.sample.memorise.hexachitecture.domains.coredomain.dto.condition.RentalCondition;
import io.sample.memorise.hexachitecture.domains.coredomain.enums.RetryGrade;
import io.sample.memorise.hexachitecture.domains.coredomain.exceptions.NoSearchTargetCar;
import io.sample.memorise.hexachitecture.domains.coredomain.services.usecase.CarRentalUseCase;
import io.sample.memorise.hexachitecture.domains.coredomain.services.usecase.CarSellingUseCase;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Service
public class CarService implements CarSellingUseCase, CarRentalUseCase {

    RentalCarDataSearch rentalCarDataSearch;

    @Override
    public TargetCar rentalCar(RentalCondition rentalCondition) throws NoSearchTargetCar {
        TargetCar selectResult = null;

        List<TargetCar> carList = null;
        if(rentalCondition.isOkToRentalUsedCar()){
            carList = rentalCarDataSearch.getEveryCarListInBudget(rentalCondition.getBudget());
        } else {
            carList = rentalCarDataSearch.getOnlyNiceCarListInBudget(rentalCondition.getBudget());
        }

        selectResult = getTargetCarFromCarList(rentalCondition, carList);

        /*TODO
         * 만일 domain과 어울리지 않는 로직이 끼어있다면
         * 다른 domain으로 옮기고, 해당 usecase를 port에서 호출하도록 변경
         * */
        updateCustomerStatus(rentalCondition);

        return selectResult;
    }

    @Override
    public List<TargetCar> rentalBunchOfCar(RentalCondition rentalCondition) {
        return null;
    }

    @Override
    public TargetCar sellCar(BuyerCondition buyerCondition) {
        return null;
    }

    @Override
    public List<TargetCar> sellBunchOfCar(BuyerCondition buyerCondition) {
        return null;
    }

    private void updateCustomerStatus(RentalCondition rentalCondition) {
        if(RetryGrade.NORMAL.isRetryable(rentalCondition.getRetryCount())) {
            log.info("일반 고객");
        } else if(RetryGrade.SLIGHT_ANGRY.isRetryable(rentalCondition.getRetryCount())) {
            log.info("소노 고객");
        } else if(RetryGrade.ANGRY.isRetryable(rentalCondition.getRetryCount())) {
            log.info("중노 고객");
        } else if(RetryGrade.VERY_ANGRY.isRetryable(rentalCondition.getRetryCount())) {
            log.info("대노 고객");
        } else if(RetryGrade.EXTREMELY_ANGRY.isRetryable(rentalCondition.getRetryCount())) {
            log.info("극대노 고객");
        }
    }

    private TargetCar getTargetCarFromCarList(RentalCondition rentalCondition, List<TargetCar> carList) throws NoSearchTargetCar {
        TargetCar selectResult = null;
        if(carList.size() < rentalCondition.getRetryCount()) {
            selectResult = carList.get(rentalCondition.getRetryCount());
        } else {
            throw new NoSearchTargetCar("No car in budget");
        }
        return selectResult;
    }
}
