package racingcar.io;

import static racingcar.global.constant.Config.CAR_NAME_DELIMITER;
import static racingcar.global.util.Validator.ValidateMovementNumber;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readCarName() {
        String input = readLine();
        return getSplit(input);
    }

    private List<String> getSplit(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .toList();
    }

    public int readMovementNumber() {
        String number = readLine();
        ValidateMovementNumber(number);
        return Integer.parseInt(number);
    }

    private String readLine() {
        return Console.readLine();
    }
}
