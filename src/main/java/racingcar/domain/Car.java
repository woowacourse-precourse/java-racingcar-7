package racingcar.domain;

public class Car {
    private static final int nameLimit = 5;
    private String name;
    private int location;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void move() {
        location += 1;
    }

    private static void validate(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 공백으로 할 수 없습니다.");
        } if (name.length() > nameLimit) {
            throw new IllegalArgumentException("자동차의 이름은 5글자를 넘지 않아야 합니다.");
        }
    }
}
