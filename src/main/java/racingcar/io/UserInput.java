package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private static final String SEPARATOR = ",";

    public void  getCars() {
        String input = Console.readLine();
        validateEmptyInput(input);
        validateContainsSeparator(input);
        String[] carsName = input.split(SEPARATOR);
    }

    public void getGameCount() {
        String input = Console.readLine();
        validateEmptyInput(input);
        validateNumber(input);
    }

    private void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 값이 숫자가 아닙니다");
        }
    }

    private void validateContainsSeparator(String input) {
        if (hasNotSeparator(input)) {
            throw new IllegalArgumentException("[ERROR] 입력값은 쉼표(,)를 포함해야 합니다");
        }
    }

    private void validateEmptyInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 빈 문자열은 입력할 수 없습니다");
        }
    }

    private static boolean hasNotSeparator(String input) {
        return !input.contains(SEPARATOR);
    }


}
