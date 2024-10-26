package racingcar.model.position;

import static racingcar.common.constant.RaceConstant.POSITION_ICON;

public class PositionBuilder {

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
