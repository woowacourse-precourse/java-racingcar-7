package racingcar.util;

public class Constants {
    public static final String CAR_NAME_INPUT_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String EMPTY_INPUT_ERROR_MESSAGE = "입력값은 비어있을 수 없습니다.";
    public static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    public static final String DUPLICATE_CAR_NAME_ERROR_MESSAGE = "자동차 이름으로 동일한 값이 사용될 수 없습니다.";
    public static final String CAR_NAME_CONTAIN_SPACE_ERROR_MESSAGE = "자동차 이름에 공백이 들어갈 수 없습니다.";
    public static final String CAR_NAME_CHARACTER_ERROR_MESSAGE = "이름에 알파벳, 또는 한글 이외의 값이 들어갈 수 없습니다.";

    public static final String CAR_NAME_REGEX = "^[a-zA-Z가-힣]+$";

    public static final String COUNT_INPUT_PROMPT = "시도할 횟수는 몇 회인가요?";
}
