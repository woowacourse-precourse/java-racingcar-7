package racingcar.domain;

public class Car {
    private static final String POSITION_DISPLAY_CHARACTER = "-";
    private static final String STATUS_FORMAT = "%s : %s";
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String getStatus() {
        String position = POSITION_DISPLAY_CHARACTER.repeat(distance);
        String status = String.format(STATUS_FORMAT, name, position);

        return status;
    }

    public void move() {
        distance++;
    }
}
