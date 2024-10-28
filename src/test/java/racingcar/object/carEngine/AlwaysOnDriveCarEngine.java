package racingcar.object.carEngine;

import racingcar.racingapp.model.car.carEngine.CarEngine;

public class AlwaysOnDriveCarEngine implements CarEngine {

    @Override
    public boolean attemptDriveEngine() {
        return true;
    }

}
