package racingcar.domain.car;

import static racingcar.domain.race.constants.RaceCriterion.MOVING_FORWARD;

import racingcar.domain.acceleration.Acceleration;
import racingcar.domain.car.vo.CarName;
import racingcar.domain.car.vo.Position;

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

    public boolean isAtPosition(int targetPosition) {
        return this.position.equals(Position.of(targetPosition));
    }

    @Override
    public String toString() {
        return name.value() + " : " + "-".repeat(position.value());
    }
}
