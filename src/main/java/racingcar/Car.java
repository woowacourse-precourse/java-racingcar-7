package racingcar;

public class Car {
    private static final int POWER_THRESHOLD = 4;
    private static final String POSITION_MARKER = "-";

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int power) {
        if (power >= POWER_THRESHOLD) {
            this.distance++;
        }
    }

    public String getInfo() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + " : ");

        for (int i = 0; i < distance; i++) {
            builder.append(POSITION_MARKER);
        }

        return builder.toString();
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
