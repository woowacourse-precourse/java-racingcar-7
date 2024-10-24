package racingcar.common.constant;

import racingcar.common.wrapper.Range;

public class Constant {
    public static final Range ROUND_VALUE_RANGE = Range.of(0, 2147483647);
    public static final Range MOVE_FORWARD_RANGE = Range.of(4, 9);
    public static final Range STOP_RANGE = Range.of(0, 3);
    public static final Integer MAX_CAR_NAME_LENGTH = 5;
    public static final Integer DEFAULT_MOVE_DISTANCE = 1;
    public static final String DELIMITER = ",";
}
