package racingcar.domain;

import racingcar.util.RandomGenerator;

public class RacingCar {

    String name;
    long moveCount;
    RandomGenerator randomGenerator;

    public RacingCar(String name, RandomGenerator randomGenerator) {
        this.name = name;
        this.moveCount = 0;
        this.randomGenerator = randomGenerator;
    }

    public void move() {
        // 움직일 수 있는 경우 : 무작위 숫자 4 이상
        if (randomGenerator.pickNumberInRange(0, 9) >= 4) {
            moveCount++;
        }
        ;
    }

    public long getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }
}
