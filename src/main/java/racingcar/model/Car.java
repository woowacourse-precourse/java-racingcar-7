package racingcar.model;

import racingcar.utils.CarNameValidator;
import racingcar.utils.Engine;
import racingcar.utils.Validator;

public class Car {
    private final String CarName;
    private final Engine engine;
    Validator validator = new CarNameValidator();

    public Car(String carName, Engine randomEngine) {
        validator.validation(carName);
        this.CarName = carName;
        this.engine = randomEngine;
    }

    public String getCarName() {
        return CarName;
    }

    public boolean getEnginePower() {
        return engine.isEngineRunning();
    }

}
