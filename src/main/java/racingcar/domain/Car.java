package racingcar.domain;

public class Car {
    private static final int INITIAL_POSITION = 0;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = INITIAL_POSITION;  // 초기 위치는 0으로 설정
    }

    public void move() {
        position++;
    }

    public String displayPosition() {
        return name + " : " + "-".repeat(position);
    }
}