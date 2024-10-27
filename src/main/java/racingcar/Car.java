package racingcar;

public class Car {
    private final String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0; // 초기 이동 횟수는 0으로 설정
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        this.moveCount++;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(moveCount);
    }
}
