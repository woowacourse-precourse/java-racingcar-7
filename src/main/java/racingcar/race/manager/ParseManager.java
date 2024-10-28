package racingcar.race.manager;

public class ParseManager {
    private static final String ERROR_MESSAGE_IF_IT_IS_NOT_A_NUMBER = "숫자를 입력해야합니다.";

    public int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_IF_IT_IS_NOT_A_NUMBER, e);
        }
    }
}
