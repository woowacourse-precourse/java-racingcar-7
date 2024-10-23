package racingcar;

public class Car {

    private final String name;
    private Long distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0L;
    }

    public void execute(final int command) {
        if (command >= 4) {
            this.distance++;
        }
    }
}
