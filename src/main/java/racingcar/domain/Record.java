package racingcar.domain;

public class Record {
    private String carName;
    private int distance;

    public Record(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }
}
