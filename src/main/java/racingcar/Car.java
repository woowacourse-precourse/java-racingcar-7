package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void roleDice(int min, int max) {
        if (isForward(pickNumberInRange(min, max))) {
            this.position++;
        }
    }

    public boolean isFasterThan(Car car) {
        return this.getPosition() > car.getPosition();
    }

    public boolean isDrawWith(Car car) {
        return this.getPosition() == car.getPosition();
    }

    private boolean isForward(int num) {
        return  num >= RaceManager.MIN_FORWARD_NUM;
    }
}
