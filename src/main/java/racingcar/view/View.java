package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.global.message.ErrorMessage;
import racingcar.global.message.ViewMessage;
import racingcar.model.Car;
import racingcar.model.Cars;

public class View {
    public static String displayCarNameInputPrompt() {
        System.out.println(ViewMessage.CAR_NAME_INPUT_PROMPT.getMessage());
        String carNamesInput = Console.readLine().trim();
        return carNamesInput;
    }

    public static int displayTryCountInputPrompt() {
        System.out.println(ViewMessage.TRY_COUNT_INPUT_PROMPT.getMessage());
        String tryCountInput = Console.readLine().trim();

        try {
            int tryCount = Integer.parseInt(tryCountInput);
            validateTryCount(tryCount);
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT_FORMAT.getMessage());
        }
    }

    private static void validateTryCount(int tryCount) {
        if (tryCount <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT_VALUE.getMessage());
        }
    }

    public static void printlnRaceResult() {
        System.out.println(ViewMessage.RACE_RESULT_HEADER.getMessage());
    }

    public static void printMoveResult(Cars cars) {
        for (Car car : cars.getCarList()) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();

        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i).getName());
            appendCommaIfNeeded(winnerNames, i, winners.size());
        }

        System.out.println(ViewMessage.FINAL_WINNER.getMessage() + winnerNames.toString());
    }

    private static void appendCommaIfNeeded(StringBuilder winnerNames, int index, int size) {
        if (index < size - 1) {
            winnerNames.append(", ");
        }
    }

}
