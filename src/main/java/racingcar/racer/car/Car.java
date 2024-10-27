package racingcar.racer.car;

import racingcar.racer.Racer;

public class Car implements Racer {
    String distance = "";
    String name;

    CarUtils carUtils = new CarUtils();

    public Car(String name) {
        this.name = name;
    }

    @Override
    public void tryMove() {
        int randomNum = carUtils.pickNumber(0, 9);
        if (carUtils.isMovable(randomNum)) {
            distance += "-";
        }
    }

    public String getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
