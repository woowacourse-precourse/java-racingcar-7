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

        Racing racing = new Racing(inputCars, inputTrialCount);

        System.out.println("\n" + PrintMessage.PRINT_RACE_RESULT.getMessage());
        while (racing.trialCount-- > 0) {
            racing.runRace();
        }

        String winnerList = racing.createWinnerList();
        System.out.println(PrintMessage.PRINT_FINAL_WINNER.formatWinner(winnerList));
    }
}
