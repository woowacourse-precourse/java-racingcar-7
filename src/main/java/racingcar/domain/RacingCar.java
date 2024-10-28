package racingcar.domain;

public class RacingCar {

    private static final int ID_MIN_LENGTH = 5;
    private static int winnerDistance = 0;

    private final String id;
    private int distance = 0;

    public RacingCar(String id) {
        validateNameLength(id);
        this.id = id;
    }

    private void validateNameLength(String id) {
        if (id == null || id.isEmpty() || id.contains("\n")) {
            throw new IllegalArgumentException("유효하지 않은 자동차 이름입니다.");
        }
        if (id.length() > ID_MIN_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public int moveForward() {
        winnerDistance = Math.max(++distance , winnerDistance);
        return distance;
    }

    public boolean isWinner() {
        return distance == winnerDistance;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " : " + "-".repeat(distance);
    }
}
