package racingcar.domain.race;

public class Record {
    private final String carName;
    private final int distance;

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
