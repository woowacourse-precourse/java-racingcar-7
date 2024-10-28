package racingcar;

public class ExceptionMessage {

    private ExceptionMessage() {
    }

    public static final String ERROR_CAR_NAME_DUPLICATE = "자동차 이름을 중복해서 사용할 수 없습니다";
    public static final String ERROR_CAR_NAME_NOT_EXIST = "자동차 이름이 존재하지 않습니다";
    public static final String ERROR_CAR_NAME_EMPTY = "쉼표 이전 또는 이후에 자동차 이름이 존재하지 않습니다";
    public static final String ERROR_CAR_NAME_LENGTH = "자동차 이름은 5자 이하만 가능합니다";
    public static final String ERROR_TRY_COUNT_NOT_NATURAL_NUMBER = "시도할 횟수가 자연수가 아닙니다";
}
