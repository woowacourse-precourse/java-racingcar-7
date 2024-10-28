package racingcar.validator;

import java.util.regex.Pattern;

public class ErrorMessage {

    public static final int NAME_SIZE=5;

    public static final Pattern NAME_STRING_PATTERN = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + "," + "]*[가-힣\\w]$");
    public static final Pattern ROUND_NUMBER_PATTERN = Pattern.compile("^[1-9][0-9]*$");

    public static final String ERROR = "[ERROR] ";
    public static final String CAR_NAME_WRONG_ERROR = ERROR + "자동차 목록은 비어있지않아야하고 ','로 구분되어야 한다.";
    public static final String CAR_NAME_SIZE_ERROR = ERROR + "자동차 이름은 1자~5자의 문자로 구성되어야 한다.";
    public static final String CAR_NAME_DUPLICATE_ERROR = ERROR + "자동차 목록은 중복이 없어야 한다.";
    public static final String ROUND_NUMBER_WRONG_ERROR = ERROR + "시도 횟수는 1 이상의 숫자여야 한다.";
}
