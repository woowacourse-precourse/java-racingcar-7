package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public static List<String> getCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        List<String> carNamesList = new ArrayList<>(Arrays.asList(carNames));

        Validator.checkIsEmpty(carNamesList);
        Validator.checkCarNameDuplicate(carNamesList);
        carNamesList.forEach(Validator::checkNameLength);

        return carNamesList;
    }

    public static int getTimes() {
        String input = Console.readLine();
        int number = Validator.checkTimeInputFormat(input);
        return Validator.checkTimeInputIsValidNumber(number);
    }
}
