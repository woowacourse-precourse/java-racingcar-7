package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move(){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.position++;
        }
    }

    public String getResult() {
        String positionDisplay = "-".repeat(position);
        return String.format("%s : %s%n", name, positionDisplay);
    }
}
