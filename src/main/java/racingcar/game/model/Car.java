package racingcar.game.model;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_CAR_NAME_LENGTH = "자동차 이름의 길이는 5를 넘을 수 없습니다.";
    private final String name;
    private final Counter counter;

    private Car(String name) {
        validateLength(name);
        this.name = name;
        this.counter = new Counter();
    }

    public static Car create(String name) {
        return new Car(name);
    }

    public boolean hasMoveCount(int count) {
        return counter.matchesCount(count);
    }

    public void increaseMoveCount() {
        counter.increase();
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return counter.getCount();
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH);
        }
    }
}