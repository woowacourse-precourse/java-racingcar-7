package racingcar.modle;

public class Car {
    private static final int START_POSITION = 0;
    private static final int PLUS_ONE = 1;

    private final String name;
    private final int position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    private Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car move(){
        return new Car(name, position + PLUS_ONE);
    }

    public int getPosition() {
        return position;
    }
}
