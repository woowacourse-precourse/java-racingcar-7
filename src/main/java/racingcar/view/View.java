package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.global.message.ErrorMessage;
import racingcar.model.Car;
import racingcar.model.Cars;

public class View {
    public static String displayCarNameInputPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine().trim();
        return carNamesInput;
    }

    public static int displayTryCountInputPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
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
        System.out.println("\n실행 결과");
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

        System.out.println("최종 우승자 : " + winnerNames.toString());
    }

    private static void appendCommaIfNeeded(StringBuilder winnerNames, int index, int size) {
        if (index < size - 1) {
            winnerNames.append(", ");
        }
    }

}
