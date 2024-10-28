package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String GetName() {
        return name;
    }

    public int GetPosition() {
        return position;
    }

    public void Move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
            position++;
        }
    }

    public String Result() {
        return name + " : " + "-".repeat(position);
    }
}
