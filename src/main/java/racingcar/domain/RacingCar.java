package racingcar.domain;

public class RacingCar {

    public static final int MIN_CAR_NAME_LENGTH = 5;
    private static int maxDistance = 0;

    private final String id;
    private int distance = 0;

    public RacingCar(String id) {
        if (id.length() > MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.id = id;
    }

    public void moveForward() {
        int nextDistance = ++this.distance;
        if (nextDistance > maxDistance) {
            maxDistance = nextDistance;
        }
    }

    public boolean isWinner() {
        return this.distance == maxDistance;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " : " + "-".repeat(distance);
    }
}
