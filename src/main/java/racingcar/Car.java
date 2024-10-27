package racingcar;

public class Car {

    private final String name;

    private Integer distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public void advance(int rating) {
        if (rating >= 4) {
            distance++;
        }
    }

    public Integer getDistance() {
        return this.distance;
    }

    public String getTravelDistance() {
        return "-".repeat(distance);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", this.getName(), this.getTravelDistance());
    }

}
