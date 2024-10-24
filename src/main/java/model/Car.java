package model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    //전진 할지 말지 결정
    public void goOrNot() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            this.distance += 1;
        }
    }

    //테스트를 위해 만들어짐.
    public void setDistance(int distance) {
        this.distance = distance;
    }
}
