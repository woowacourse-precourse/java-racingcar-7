package racingcar.domain;

import racingcar.util.RandomGenerator;

import static racingcar.util.ConditionConstant.MOVE_CONDITION;

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
        if (randomGenerator.pickNumberInRange(0, 9) >= MOVE_CONDITION) {
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
