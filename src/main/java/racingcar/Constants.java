package racingcar;

import java.util.regex.Pattern;

public class Constants {
    public static final String CAR_NAME_DELIMITER = ",";
    public static final String WINNER_DELIMITER = ", ";

    public static final int MAX_NAME_SIZE = 5;
    public static final int MIN_NUM_RANGE = 0;
    public static final int MAX_NUM_RAGNE = 9;
    public static final int MOVE = 4;

    public static final Pattern nameStringPattern = Pattern.compile("^[가-힣\\w]+[가-힣\\w" + CAR_NAME_DELIMITER + "]*[가-힣\\w]$");
    public static final Pattern roundNumStringPattern = Pattern.compile("^[1-9][0-9]*$");

    public static final String CAR_NAME_DUPLICATE = "중복된 자동차 이름이 존재합니다.";
    public static final String CAR_NAME_LENGTH_WRONG = "자동차 이름의 길이가 잘못되었습니다.";
    public static final String CAR_NAME_WRONG = "자동차 목록은 쉼표로 구분되고, 비어있지 않은 문자여야 합니다.";
    public static final String ROUND_NUM_WRONG = "시도 횟수는 1 이상의 숫자여야 합니다.";
}
