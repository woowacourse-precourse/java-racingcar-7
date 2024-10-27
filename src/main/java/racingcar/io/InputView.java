package racingcar.io;

import static racingcar.global.constant.Config.CAR_NAME_DELIMITER;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String[] readCarName() {
        String input = readLine();
        return getSplit(input);
    }

    private String[] getSplit(String input) {
        return input.split(CAR_NAME_DELIMITER);
    }

    public int readMovementNumber() {
        String number = readLine();
        return Integer.parseInt(number);
    }

    private String readLine() {
        return Console.readLine();
    }
}
