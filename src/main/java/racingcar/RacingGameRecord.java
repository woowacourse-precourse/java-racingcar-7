package racingcar;

public class RacingGameRecord {

    private int round;
    private int distance;
    private Car car;

    public RacingGameRecord(int round, int distance, Car car) {
        this.round = round;
        this.distance = distance;
        this.car = new Car(car.getName(), car.currentLocation());
    }

    @Override
    public String toString() {
        return "RacingGameRecord{" +
                "count=" + round +
                ", distance=" + distance +
                ", car=" + car +
                '}';
    }
}
