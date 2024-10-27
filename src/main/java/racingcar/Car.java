package racingcar;

import racingcar.Engine;

public class Car {
    private static final int NAME_LENGTH_LIMIT = 5;

    private Engine engine;
    private String name;

    public Car(Engine engine, String name) {
        validateNameLength(name);
        this.name = name;
        this.engine = engine;
    }

    public void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름 길이는 1이상 5이하만 가능합니다.");
        }
    }

    public int move() {
        return engine.active();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
