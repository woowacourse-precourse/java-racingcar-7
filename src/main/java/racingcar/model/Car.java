package racingcar.model;

public class Car {
    private final String name;
    private int currentPosition = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자 사이여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void advancePosition(boolean shouldMove) {
        if (shouldMove) {
            currentPosition++;
        }
    }

    public String getPositionAsDashes() {
        return "-".repeat(currentPosition);
    }
}
