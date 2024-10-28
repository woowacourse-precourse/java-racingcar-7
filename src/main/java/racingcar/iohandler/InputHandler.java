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
        if (input.equals("0")) {
            throw new IllegalArgumentException("1 이상의 숫자를 입력 해 주세요");
        }
        boolean isNumeric = input.chars().allMatch(Character::isDigit);
        if (!isNumeric) {
            throw new IllegalArgumentException("양수만 입력 해 주세요.");
        }
        return Integer.parseInt(input);
    }
}
