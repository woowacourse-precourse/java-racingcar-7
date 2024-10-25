package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

    }
}

class Car {
    private final String name;
    private int movingCount;

    public Car(String name) {
        this.name = name;
        this.movingCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMovingCount() {
        return movingCount;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            movingCount++;
        }
    }
}
