package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
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

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
