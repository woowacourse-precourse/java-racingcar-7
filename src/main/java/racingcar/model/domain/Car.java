package racingcar.model.domain;

import racingcar.model.domain.vo.CarName;
import racingcar.model.domain.vo.Distance;

public class Car {
    private final CarName name;
    private Distance movedDistance;

    public Car(String name) {
        this.name = new CarName(name);
        movedDistance = new Distance(0);
    }

    public void moveForward() {
        movedDistance = movedDistance.add();
    }

    public String getName() {
        return name.getName();
    }

    public int getMovedDistance() {
        return movedDistance.getValue();
    }

}
