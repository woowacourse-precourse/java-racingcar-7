package racingcar.iohandler;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public String[] getCarNamesFromUser() {
        String input = Console.readLine();
        String[] names = input.split(",");
        return names;
    }

    public int getMoveCountFromUser() {
        String input = Console.readLine();
        boolean isNumeric = input.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            throw new IllegalArgumentException("숫자만 입력 해 주세요.");
        }
        return Integer.parseInt(input);
    }
}
