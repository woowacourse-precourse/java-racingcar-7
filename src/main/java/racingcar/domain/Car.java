package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int START_COUNT = 0;
    private static final int DEFAULT_RANDOM_NUMBER = 0;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private final String name;
    private int randomNumber;
    private int winCount;

    public Car(String name) {
        this.name = name;
        this.randomNumber = DEFAULT_RANDOM_NUMBER;
        this.winCount = START_COUNT;
    }

    public void move() {
        randomNumber = makeRandomNumber();
        if (randomNumber > 3) {
            winCount++;
        }
    }

    private int makeRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    public String getName() {
        return name;
    }

    public int getWinCount() {
        return winCount;
    }
}
