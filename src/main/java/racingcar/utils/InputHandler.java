package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String[] inputNames(String promptMessage) {
        System.out.println(promptMessage);
        String input = Console.readLine();
        return input.split(",");
    }

    public int inputNumber(String promptMessage) {
        System.out.println(promptMessage);
        String input = Console.readLine();
        try {
            int number = Integer.parseInt(input);
            if (number <= 0) throw new NumberFormatException();
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값은 양의 정수여야 합니다.");
        }
    }
}
