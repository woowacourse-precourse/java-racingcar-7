package racingcar.model;

public class ExecutionResult {

    private static final String DISTANCE_SYMBOL = "-";
    private static final String DISPLAY_PATTERN = "%s : %s";
    private final String carName;
    private final int movedDistance;

    public ExecutionResult(String carName, int movedDistance) {
        this.carName = carName;
        this.movedDistance = movedDistance;
    }

    @Override
    public String toString() {
        return DISPLAY_PATTERN.formatted(carName, generateDistanceIndicator(movedDistance));
    }

    private String generateDistanceIndicator(int movedDistance) {
        return DISTANCE_SYMBOL.repeat(movedDistance);
    }
}
