package racingcar.controller;

import racingcar.util.Direction;

public class DirectionController {

    public Direction determineDirectionUsingThreshold(int randomValue) {
        final int threshold = 4;
        if (randomValue < threshold) {
            return Direction.STOP;
        }
        return Direction.FORWARD;
    }

}
