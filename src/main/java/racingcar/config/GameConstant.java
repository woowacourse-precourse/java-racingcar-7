package racingcar.config;

public class GameConstant {
    private GameConstant() {
        throw new IllegalStateException("Config Class");
    }

    public static final String CAR_NAME_DELIMITER = ",";
    public static final int CAR_NAME_UPPER_BOUND = 5;
    public static final int MOVEMENT_THRESHOLD = 4;
}
