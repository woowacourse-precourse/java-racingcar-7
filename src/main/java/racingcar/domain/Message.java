package racingcar.domain;

public class Message {

    private static final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT = "시도할 횟수는 몇 회인가요?";

    private static final String INPUT_BLANK_ERROR = "입력값이 존재하지 않습니다.";
    private static final String CAR_NAME_LENGTH_ERROR = "이름은 1자 이상 5자 이하로 입력해야 합니다.";
    private static final String CAR_NAME_FORMAT_ERROR = "이름은 영어와 숫자만 입력 가능합니다.";
    private static final String CAR_NAME_DUPLICATION_ERROR = "중복된 이름이 존재합니다.";

    private static final String TRY_COUNT_INPUT_ERROR = "시도 횟수는 1회 이상으로 입력해야 합니다.";

    public static String promptInputCarNames() {
        return INPUT_CAR_NAMES;
    }

    public static String promptInputTryCount() {
        return INPUT_TRY_COUNT;
    }

    public static String inputBlankError() {
        return INPUT_BLANK_ERROR;
    }

    public static String carNameLengthError() {
        return CAR_NAME_LENGTH_ERROR;
    }

    public static String carNameFormatError() {
        return CAR_NAME_FORMAT_ERROR;
    }

    public static String carNameDuplicationError() {
        return CAR_NAME_DUPLICATION_ERROR;
    }

    public static String tryCountInputError() {
        return TRY_COUNT_INPUT_ERROR;
    }

}
