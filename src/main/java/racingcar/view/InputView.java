package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.validator.CarNameValidator;

public class InputView {

    public static String[] getCarNames() {
        String input = Console.readLine();
        CarNameValidator.commaEnding(input);
        String[] carNames = input.split(",");

        for (String name : carNames) {
            CarNameValidator.Spaces(name);
            CarNameValidator.Characters(name);
        }

        return carNames;
    }

    public static String getRound() {
        String value = Console.readLine();
        return value;
    }


}
