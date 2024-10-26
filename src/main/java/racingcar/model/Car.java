package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;


    public Car(String name) {
        this.name = name;
    }

    private static boolean canMove() {
        return Randoms.pickNumberInRange(0,9) >= 4;
    }

    public void move() {
        if(canMove()) {
            position ++;
        }
    }
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
