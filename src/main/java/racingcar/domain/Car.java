package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int INITIAL_POSITION = 0;  // 초기 포지션을 상수로 관리
    private static final int MOVE_THRESHOLD = 4;    // 이동을 결정하는 기준값
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;
    }

    public void move() {
        int randomValue = RandomNumberGenerator.generate(RANDOM_MIN, RANDOM_MAX);
        if (randomValue >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
