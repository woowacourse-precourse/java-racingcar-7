package racingcar.domain;

public class Car {
    // 이름, 위치
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5글자 이하가 되어야합니다.");
        }
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 빈칸 혹은 공백일 수 없습니다.");
        }

        this.name = name;
    }

    public void movePosition() {
        position += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
