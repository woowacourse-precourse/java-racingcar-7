package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(name + " is more than 5 letters.");
        }
        this.name = name;
        position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void randomGo() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }

    public void print() {
        System.out.println(name + " : " + "-".repeat(position));
    }
}
