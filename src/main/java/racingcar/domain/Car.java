package racingcar.domain;

public class Car {

    private static final String EXECUTE_RESULT_DELIMITER = " : ";
    private static final String CURRENT_CAR_POSITION = "-";
    private static final Integer INITIAL_POSITION = 0;
    private static final String NEW_LINE = "\n";

    private final String name;
    private Integer position;

    private Car(final String name, int position) {
        this.name = name;
        this.position = position;
    }

    public static Car createCar(final String name) {
        return new Car(name, INITIAL_POSITION);
    }

    public String getName() {
        return name;
    }

    public Integer getPosition() {
        return position;
    }

    public void move() {
        Status status = Status.createStatus();
        if (status.validateMoveForward()) {
            position++;
        }
    }

    public String displayPosition() {
        return name + EXECUTE_RESULT_DELIMITER + CURRENT_CAR_POSITION.repeat(position) + NEW_LINE;
    }
}
