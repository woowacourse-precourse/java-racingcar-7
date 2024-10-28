package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private static final int INITIAL_POSITION = 0;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;  // 초기 위치는 0으로 설정
    }

    public void tryMove() {
        if (RandomNumberGenerator.getRandomNumber() >= MOVE_THRESHOLD) {
            move();
        }
    }

    public void move() {
        position++;
    }

    public String displayPosition() {
        return name + " : " + "-".repeat(position);
    }
}