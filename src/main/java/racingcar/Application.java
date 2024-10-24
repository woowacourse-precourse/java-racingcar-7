package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.enums.PrintMessage;
import racingcar.utils.InputValidator;

public class Application {
    public static void main(String[] args) {
        System.out.println(PrintMessage.ENTER_CARS_PROMPT.getMessage());
        String inputCars = Console.readLine();

        System.out.println(PrintMessage.ENTER_TRIAL_COUNT_PROMPT.getMessage());
        String inputTrialCount = Console.readLine();

        InputValidator.validateCarNames(inputCars);
        InputValidator.validateTrialCount(inputTrialCount);
    }
}
