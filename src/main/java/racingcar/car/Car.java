package racingcar.car;

import racingcar.vo.CarName;
import racingcar.vo.Position;

public class Car {

    private final static int MOVE_FORWARD_CRITERION = 4;
    private CarName name;
    private Position position;

    public Car(final String name) {
        this.name = new CarName(name);
        this.position = Position.init();
    }

    public void move(int randomNumber) {
        if (randomNumber >= MOVE_FORWARD_CRITERION) {
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
