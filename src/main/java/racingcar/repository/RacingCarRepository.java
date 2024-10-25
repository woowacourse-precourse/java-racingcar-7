package racingcar.repository;

import racingcar.domain.RacingCar;

import java.util.LinkedList;
import java.util.List;

public class RacingCarRepository {
    List<RacingCar> racingCars = new LinkedList<>();

    public void save(RacingCar racingCar){
        racingCars.add(racingCar);
    }

}
