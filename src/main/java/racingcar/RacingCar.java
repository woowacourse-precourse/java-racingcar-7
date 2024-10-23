package racingcar;

public class RacingCar {

    private final String id;
    private int distance = 0;

    public RacingCar(String id) {
        if (id.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.id = id;
    }

    public int moveForward() {
        return ++this.distance;
    }

    public boolean isSameDistance(int distance) {
        return this.distance == distance;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " : " + "-".repeat(distance);
    }
}
