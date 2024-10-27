package racingcar.domain.model;

public class Car {
    private final String name;
    private Integer moveCount;

    private Car(String name, Integer moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    static Car of(String name) {
        return new Car(name, 0);
    }

    public String getName() {
        return name;
    }

    public Integer getMoveCount() {
        return moveCount;
    }
}
