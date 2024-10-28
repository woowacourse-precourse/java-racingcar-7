package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int position = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if(randomNumber >= 4) {
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
