package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.Validator;

public class InputView {

    public List<String> getCarNameList() {
        System.out.println(ConsoleMessage.ENTER_CAR_NAME);
        return splitString(escapeSpecialRegexChars(Console.readLine()));
    }

    public long getTryNumber() {
        System.out.println(ConsoleMessage.ENTER_TRY_NUMBER);
        return Validator.isNumeric(Console.readLine());
    }

    public void close() {
        Console.close();
    }

    private List<String> splitString(String input) {
        String carNameString = Validator.isNotBLANK(input);

        List<String> carNameList = List.of(carNameString.split(","));

        Validator.isDuplicated(carNameList);

        for (String carName : carNameList) {
            Validator.overFiveChars(carName);
        }

        return carNameList;
    }

    private String escapeSpecialRegexChars(String input) {
        return input.replaceAll("([\\\\.\\^\\$\\*\\+\\?\\(\\)\\[\\]\\{\\}\\|])", "\\\\$1");
    }
}
