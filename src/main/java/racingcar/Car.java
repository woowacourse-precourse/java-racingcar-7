package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }
    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) this.distance += 1;
    }
    public int getDistance(){
        return distance;
    }
    public String getName() {
        return name;
    }
}
