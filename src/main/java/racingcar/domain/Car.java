package racingcar.domain;

public class Car {

    private final String name;

    private Integer move = 0;

    private Car(String name) {
        this.name = name;
    }

    public static Car create(String name) {
        CarValidation.checkCarNameLength(name);
        return new Car(name);
    }

    public void move() {
        move++;
    }

    public String getName() {
        return name;
    }

    public Integer getMove() {
        return move;
    }
}
