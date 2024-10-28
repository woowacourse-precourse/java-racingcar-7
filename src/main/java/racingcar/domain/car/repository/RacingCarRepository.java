package racingcar.domain.car.repository;

import racingcar.domain.car.RacingCar;

import java.util.List;

public interface RacingCarRepository {
    void saveRacingCar(RacingCar racingCar);

    List<RacingCar> getRacingCars();
}
