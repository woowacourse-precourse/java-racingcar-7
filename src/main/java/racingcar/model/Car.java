package racingcar.model;

import racingcar.utils.CarNameValidator;
import racingcar.utils.Engine;
import racingcar.utils.Validator;

public class Car {
    private final String CarName;
    private final Engine engine;
    private int position;

    Validator validator = new CarNameValidator();

    public Car(String carName, Engine randomEngine) {
        validator.validation(carName);
        this.CarName = carName;
        this.engine = randomEngine;
        this.position = 0;
    }

    public String getCarName() {
        return CarName;
    }

    public boolean move() {
        if (engine.isEngineRunning()) {
            position++;
            return true;
        }
        return false;
    }

    public int getPosition() {
        return position;
    }

}
