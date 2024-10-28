package racingcar.model;

// 자동차 클래스
public class Car {
    private final String name;
    private int position;

    // 생성자
    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPositionValue() {
        return position;
    }

    public void move() {
        position++;
    }

    public String getPosition() {
        return "-".repeat(position);
    }
}
