package racingcar.io;

import racingcar.model.Racingcar;
import racingcar.util.Constants;

import java.util.List;

public class Output {
    private static final Output instance = new Output();

    private Output() {}

    public static Output getInstance() {
        return instance;
    }

    public void printCarNameInputPrompt() {
        System.out.println(Constants.CAR_NAME_INPUT_PROMPT);
    }

    public void printCountInputPrompt() {
        System.out.println(Constants.COUNT_INPUT_PROMPT);
    }

    public void printRaceResultPrompt() {
        System.out.println(Constants.RACE_RESULT_PROMPT);
    }

    public void printResultsByCount(List<Racingcar> racingcars) {
        for (Racingcar racingcar: racingcars) {
            System.out.print(racingcar.getName() + " : ");

            int distance = racingcar.getDistance();
            for (int i = 0; i < distance; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printWinnerPrompt() {
        System.out.print(Constants.WINNER_PROMPT);
    }
}
