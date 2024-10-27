package racingcar.util;

public class SplittingRacingCarName {
    private static final String STRING_SPLITTER = ",";

    public static String[] splitRacingCarName(String racingCarNames) {
        return racingCarNames.split(STRING_SPLITTER);
    }
}
