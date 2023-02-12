package io.sample.memorise.hexachitecture.adaptors.persistence.jpa.port;

import io.sample.memorise.hexachitecture.domains.coredomain.data.RentalCarDataSearch;
import io.sample.memorise.hexachitecture.domains.coredomain.dto.car.model.TargetCar;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalCarDataSearchPort implements RentalCarDataSearch {
    @Override
    public List<TargetCar> getOnlyNiceCarListInBudget(long budget) {
        //TODO 조건에 맞는 데이터 가져오기
        //TODO 중복된 요청을 대비해서 Redis캐싱 부분 추가
        return null;
    }

    @Override
    public List<TargetCar> getEveryCarListInBudget(long budget) {
        return null;
    }
}
