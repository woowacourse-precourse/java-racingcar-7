package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }
    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) this.distance += 1;
    }
    public int getDistance(){
        return distance;
    }
    public String getName() {
        return name;
    }
}
