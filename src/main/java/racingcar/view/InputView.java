package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.message.Message;
import racingcar.validation.CarNameValidation;
import racingcar.validation.CountValidation;

public class InputView {

    public List<String> enterCarNames() {
        System.out.println(Message.enterName.getMessage());
        String userInput = Console.readLine();

        String[] carNames = userInput.split("\\s*,\\s*");
        List<String> carNameList = Arrays.asList(carNames);

        CarNameValidation.isNotEmpty(carNameList);
        CarNameValidation.isNameLengthValid(carNameList);
        CarNameValidation.isNotDuplicate(carNameList);

        return carNameList;
    }

    public int enterCount() {
        System.out.println(Message.count.getMessage());
        String userInput = Console.readLine();

        return CountValidation.convertToNaturalNum(userInput);
    }
}
