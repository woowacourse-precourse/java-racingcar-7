package racingcar.model;

import java.util.List;

public class Car {
    private final String name;
    private final List<Boolean> moveHistory;
    private final int totalDistance;
    private int distance;

    public Car(String name, List<Boolean> moveHistory) {
        this.name = name;
        this.moveHistory = moveHistory;
        this.totalDistance = calculateDistance(moveHistory);
        this.distance = 0;
    }

    public int calculateDistance(List<Boolean> moveHistory) {
        return (int) moveHistory.stream()
                .filter(Boolean::booleanValue)
                .count();
    }

    public void increaseDistance() {
        distance++;
    }

    public String getName() {
        return name;
    }

    public List<Boolean> getMoveHistory() {
        return moveHistory;
    }

    public int getTotalDistance() {
        return totalDistance;
    }

    public int getDistance() {
        return distance;
    }
}
