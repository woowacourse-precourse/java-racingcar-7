package racingcar.car;

public class Car {
    private static final String DISTANCE_FORMAT = "-";
    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void forward(boolean isForwardMovable) {
        if (isForwardMovable) {
            distance++;
        }
    }

    public String getDistanceOutput() {
        String distanceOutput = "";
        for (int i = 0; i < distance; i++) {
            distanceOutput = distanceOutput.concat(DISTANCE_FORMAT);
        }
        return distanceOutput;
    }

    public void showDistanceOutput() {
        System.out.println(name + " : " + getDistanceOutput());
    }
}
