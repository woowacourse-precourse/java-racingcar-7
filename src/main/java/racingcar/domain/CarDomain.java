package racingcar.domain;

import static racingcar.common.constant.Constant.DEFAULT_MOVE_DISTANCE;

public class CarDomain {
    private final String name;
    private Integer distance;

    private CarDomain(String name, Integer foward) {
        this.name = name;
        this.distance = foward;
    }

    public static CarDomain create(String name, Integer foward) {
        return new CarDomain(name, foward);
    }

    public String getName() {
        return name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void incrementDistance() {
        this.distance += DEFAULT_MOVE_DISTANCE;
    }
}
