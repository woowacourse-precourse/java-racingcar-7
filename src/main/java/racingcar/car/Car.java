package racingcar.car;

import static racingcar.race.constants.RaceCriterion.*;

import racingcar.Acceleration;
import racingcar.vo.CarName;
import racingcar.vo.Position;

public class Car {

    private CarName name;
    private Position position;
    private Acceleration acceleration;

    public Car(final String name, final Acceleration acceleration) {
        this.name = new CarName(name);
        this.position = Position.init();
        this.acceleration = acceleration;
    }

    public void move() {
        int forwardCriterion = acceleration.generateForwardCriterion();
        if (forwardCriterion >= MOVING_FORWARD.getCriterion()) {
            this.position = position.increase();
        }
    }

    public int getPosition() {
        return position.value();
    }

    public String getName() {
        return name.value();
    }

    @Override
    public String toString() {
        return name.value() + " : " + "-".repeat(position.value());
    }
}
