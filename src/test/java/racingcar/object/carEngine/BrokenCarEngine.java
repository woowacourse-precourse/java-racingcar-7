package racingcar.object.carEngine;

import racingcar.racingapp.model.car.carEngine.CarEngine;

public class BrokenCarEngine implements CarEngine {

    @Override
    public boolean attemptDriveEngine() {
        return false;
    }

}
