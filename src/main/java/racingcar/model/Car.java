package racingcar.model;

public class Car {

    private final String name;
    private Long position;

    public Car(String name) {
        this.name = name;
        this.position = 0L;
    }

    public String getName() {
        return name;
    }

    public Long getPosition() {
        return position;
    }

    public void move() {
        position++;
    }

    public static Car createCar(String name) {
        return new Car(name);
    }

    public String getPositionString() {
        StringBuilder sb = new StringBuilder();

        for (long i = 0L; i < position; i++) {
            sb.append("-");
        }

        return sb.toString();
    }
}
