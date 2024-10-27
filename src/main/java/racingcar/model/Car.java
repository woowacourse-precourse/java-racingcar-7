package racingcar.model;

import java.util.HashSet;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final HashSet<String> existingNames = new HashSet<>();

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
        existingNames.add(name);
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        if (existingNames.contains(name)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
        if (name.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에는 공백이 포함될 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        position++;
    }
}