package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position;
    private int randomNumber;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void moveOrStop() {
        pickRandomNumber();
        if (this.randomNumber >= 4) {
            this.position++;
        }
    }

    private void pickRandomNumber() {
        this.randomNumber = Randoms.pickNumberInRange(0, 9);
    }
}
