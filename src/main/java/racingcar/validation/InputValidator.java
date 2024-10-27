package racingcar.validation;

public class InputValidator {

    public static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    public static boolean isValidFormat(String input) {
        return input.matches("^([a-zA-Z0-9]{1,5})(,[a-zA-Z0-9]{1,5})*$");
        //기능 요구사항에는 이름의 대한 조건이 구현되어있지 않지만 현재 자동차 이름중에도 숫자가 들어간 자동차는 있기 때문에 숫자와 문자는 허용 그외 빈칸이나 다른 기호들은 불가능 하도록 설정
    }

    public static boolean isValidNumber(String input) {
        return input.matches("^[1-9]\\d*$");
    }
}
