package racingcar;

public class RoundInputParser {

    public static int parse(String input) {
        validateInput(input);
        return processInput(input);
    }

    private static void validateInput(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("진행할 라운드 값이 입력되지 않았습니다.");
        }
    }

    private static int processInput(String input) {
        int roundNum = inputToRoundNum(input);
        return validateRoundNum(roundNum);
    }

    private static int inputToRoundNum(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("아라비아 숫자값을 입력해야 합니다.");
        }
    }

    private static int validateRoundNum(int roundNum) {
        if(roundNum < 0) {
            throw new IllegalArgumentException("0이상의 횟수를 입력해야 합니다.");
        }
        return roundNum;
    }

}
