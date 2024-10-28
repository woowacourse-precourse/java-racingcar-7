package racingcar.car;

public class Car {
    private static final String distanceFormat = "-";
    private final String name;
    private int distance = 0;
    private String distanceOutput = "";

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void forward(boolean isForwardMovable) {
        if (isForwardMovable) {
            distance++;
        }
    }

    public String getDistanceOutput() {
        for (int i = 0; i < distance; i++) {
            distanceOutput = distanceOutput.concat(distanceFormat);
        }
        return distanceOutput;
    }

    public void showDistanceOutput() {
        System.out.println(name + " : " + getDistanceOutput());
    }
}
