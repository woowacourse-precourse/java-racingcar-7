package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarRace;

public class CarRaceService {

    private CarRace carRace;

    public void init(String carNames) {
        carRace = new CarRace(carNames);
    }

    public void moveCars() {
        carRace.getCars().stream()
                .filter(car -> canMove())
                .forEach(Car::move);
    }

    public List<String> getWinners() {
        return carRace.getCars().stream()
                .filter(car -> car.getMovingDistance().length() == getMaxDistance())
                .map(Car::getName)
                .toList();
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private int getMaxDistance() {
        return carRace.getCars().stream()
                .mapToInt(car -> car.getMovingDistance().length())
                .max()
                .orElseThrow(() -> new IllegalArgumentException());
    }
}
