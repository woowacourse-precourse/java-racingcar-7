package racingcar.server.model.position;

public class PositionBuilder {

    private static final String POSITION_ICON = "-";

    // Constructor
    private PositionBuilder() {
    }

    // Method
    public static Position from(Distance distance) {
        StringBuilder positionBuilder = new StringBuilder();
        distance.initiateLongStream()
                .forEach(idx -> positionBuilder.append(POSITION_ICON));
        return Position.from(positionBuilder.toString());
    }
}
