package racingcar.domain;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 비어있을 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
    }

    public void move(int randomValue) {
        if (randomValue >= 4) {
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
