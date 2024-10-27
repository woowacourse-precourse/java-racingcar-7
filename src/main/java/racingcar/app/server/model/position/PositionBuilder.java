package racingcar.app.server.model.position;

public class PositionBuilder {

    private static final String POSITION_ICON = "-";

    private PositionBuilder() {
    }

    public static Position from(Distance distance) {
        StringBuilder positionBuilder = new StringBuilder();
        distance.initiateLongStream()
                .forEach(idx -> positionBuilder.append(POSITION_ICON));
        return Position.from(positionBuilder.toString());
    }
}
