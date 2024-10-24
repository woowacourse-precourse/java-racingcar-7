package racingcar.service;

import racingcar.model.Racingcar;
import racingcar.model.Racingcars;

import java.util.List;

public class RacingService {

    private final Racingcars racingcars;

    public RacingService(Racingcars racingcars) {
        this.racingcars = racingcars;
    }

    public void saveCarName(List<String> carNameList) {
        for (String carName : carNameList) {
            Racingcar racingcar = new Racingcar(carName);
            racingcars.addCar(racingcar);
        }
    }
}
