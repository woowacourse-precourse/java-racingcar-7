package racingcar.global.constant;

public final class InvalidInputExceptionMessage {
    private static final String CAR_NAME_LENGTH_FORMAT =
            "자동차 이름은 %d자 이상 %d자 이하로 입력해 주세요.";
    private static final String CAR_NAME_EMPTY =
            "자동차 이름을 입력해 주세요.";
    private static final String CAR_COUNT_FORMAT =
            "자동차는 %d대 이상 %d대 이하로 등록해 주세요.";
    private static final String GAME_ROUND_FORMAT =
            "시도 횟수는 %d 이상 %d 이하의 자연수로 입력해 주세요.";
    private static final String GAME_ROUND_NOT_NATURAL_NUMBER =
            "1 이상의 자연수를 입력해 주세요.";


    public static String carNameLength(int minLength, int maxLength) {
        return String.format(CAR_NAME_LENGTH_FORMAT, minLength, maxLength);
    }

    public static String emptyCarName() {
        return CAR_NAME_EMPTY;
    }

    public static String carCount(int minCount, int maxCount) {
        return String.format(CAR_COUNT_FORMAT, minCount, maxCount);
    }

    public static String gameRoundRange(int minRound, int maxRound) {
        return String.format(GAME_ROUND_FORMAT, minRound, maxRound);
    }

    public static String gameRoundNotNaturalNumber() {
        return GAME_ROUND_NOT_NATURAL_NUMBER;
    }
}