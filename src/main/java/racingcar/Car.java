package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final int NAME_LENGTH_RULE = 5;
    private final int MOVE_RULE = 4;
    private final String DISTANCE_VISUALIZATION_MARK = "-";
    private int distance = 0;
    private final String CAR_NAME;

    public Car(String carName) {
        validateCarName(carName);
        this.CAR_NAME = carName;
    }

    public String getCAR_NAME() {
        return CAR_NAME;
    }

    public void visualizeDistance() {
        System.out.printf("%s : %s\n", CAR_NAME, getDistanceVisualization());
    }

    private String getDistanceVisualization() {
        return DISTANCE_VISUALIZATION_MARK.repeat(distance);
    }

    public int maxDistanceAndOtherDistance(int otherDistance) {
        return Math.max(distance, otherDistance);
    }

    public Boolean isEqualToWinnerDistance(int winnerDistance) {
        return distance == winnerDistance;
    }

    private void increaseDistance() {
        distance++;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void move() {
        if (isAbleToMove()) {
            increaseDistance();
        }
    }

    private Boolean isAbleToMove() {
        return getRandomNumber() >= MOVE_RULE;
    }

    private void validateCarName(String carName) {
        if (isEmptyCarName(carName)) {
            throw new IllegalArgumentException();
        }
        if (isOverNameLength(carName)) {
            throw new IllegalArgumentException();
        }

    }

    private Boolean isEmptyCarName(String carName) {
        return carName.isEmpty();
    }

    private Boolean isOverNameLength(String carName) {
        return carName.length() > NAME_LENGTH_RULE;
    }

}
