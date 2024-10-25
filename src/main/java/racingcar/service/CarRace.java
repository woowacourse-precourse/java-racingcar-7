package racingcar.service;

import java.util.List;
import racingcar.context.Car;

public class CarRace {
    private final Integer totalRaceRound;
    private List<Car> carGroup;

    public CarRace(String totalRaceRound, List<Car> carGroup) {
        this.totalRaceRound = Integer.parseInt(totalRaceRound); //검증, 예외 처리 필요
        this.carGroup = carGroup;
    }

    public void startCarRacing() {
        for (int raceRound = 0; raceRound < totalRaceRound; raceRound++) {
            carGroup.forEach(Car::moveCar);
        }
    }
}
