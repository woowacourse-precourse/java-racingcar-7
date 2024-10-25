package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int progressCounter;

    public Car(String name) {
        this.name = name;
        this.progressCounter = 0;
    }

    public void decideProgressByRandomNumber() {
        int randomNumber = getRandomNumber();
        if (randomNumber >= 4) progressCounter++;
    }
    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String getName() {
        return name;
    }
    public int getProgressCount() {
        return progressCounter;
    }
}
