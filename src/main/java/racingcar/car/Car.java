package racingcar.car;

import racingcar.Acceleration;
import racingcar.vo.CarName;
import racingcar.vo.Position;

public class Car {

    private final static int MOVE_FORWARD_CRITERION = 4;
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
        if (forwardCriterion >= MOVE_FORWARD_CRITERION) {
            this.position = position.increase();
        }
    }

    public int getPosition() {
        return position.value();
    }

    public String getName() {
        return name.value();
    }
}
