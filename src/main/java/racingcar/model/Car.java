package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final int GO_OR_STOP_STANDARD = 4;
    private final int RANDOM_NUMBER_UNDER_LIMIT = 0;
    private final int RANDOM_NUMBER_OVER_LIMIT = 9;


    private String name;
    private int progressCounter;

    public Car(String name) {
        this.name = name;
        this.progressCounter = 0;
    }

    public void decideProgressByRandomNumber() {
        int randomNumber = getRandomNumber();
        if (randomNumber >= GO_OR_STOP_STANDARD) {
            progressCounter++;
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_NUMBER_UNDER_LIMIT, RANDOM_NUMBER_OVER_LIMIT);
    }

    public String getName() {
        return name;
    }

    public int getProgressCount() {
        return progressCounter;
    }
}
