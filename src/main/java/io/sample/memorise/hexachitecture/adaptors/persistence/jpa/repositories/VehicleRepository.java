package io.sample.memorise.hexachitecture.adaptors.persistence.jpa.repositories;

import io.sample.memorise.hexachitecture.adaptors.persistence.jpa.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
