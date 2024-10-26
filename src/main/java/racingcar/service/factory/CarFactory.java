package racingcar.service.factory;

import racingcar.model.RacingCar;

import java.util.List;

public interface CarFactory {
    List<RacingCar> createCars(List<String> participants);
}
