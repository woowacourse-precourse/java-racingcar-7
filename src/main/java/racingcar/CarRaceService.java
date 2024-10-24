package racingcar;

import racingcar.domain.CarRace;

public class CarRaceService {

    private CarRace carRace;

    public void init(String carNames) {
        carRace = new CarRace(carNames);
    }
}
