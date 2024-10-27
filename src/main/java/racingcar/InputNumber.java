package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputNumber {
    public int TryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int input;
        try {
            input = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (input < 1)
            throw new IllegalArgumentException();

        return input;
    }
}
