package racingcar.domain;

public class Car {

    private static final String INFORMATION_FORMAT = "%s : %s";
    private static final String DISTANCE_SYMBOL = "-";
    private static final int NAME_LENGTH_LIMIT = 5;

    private String name;
    private long position;

    private Car() {}

    public Car(String name) {
        validateNameLength(name);
        this.name = name;
        this.position = 0L;
    }

    private void validateNameLength(String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public long getPosition() {
        return position;
    }

    public String getInformation() {
        String totalDistance = DISTANCE_SYMBOL.repeat((int) this.position);
        return String.format(INFORMATION_FORMAT, this.name, totalDistance);
    }

    public void move(long distance) {
        this.position += distance;
    }

}
