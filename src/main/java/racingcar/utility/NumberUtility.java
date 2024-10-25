package racingcar.utility;

import racingcar.exception.RaceException;

public class NumberUtility {

    private final static String NUMBER_REGEX = "^[0-9]+(\\.[0-9]+)?$";
    private final static String INVALID_PARSE_NUMBER_MESSAGE = "유효하지 않은 숫자입니다 (범위를 초과하였을 수 있습니다. int 범위까지내 입력해주세요)";

    public static boolean isNumberStr(String input){
        return input.matches(NUMBER_REGEX);
    }

    public static boolean isPositiveNumber(int numberStr) {
        return numberStr >= 0;
    }

    public static int getNumber(String numberStr) {
        if(!isNumberStr(numberStr)){
            throw new RaceException(INVALID_PARSE_NUMBER_MESSAGE);
        }
        return (int) Double.parseDouble(numberStr);
    }
}
