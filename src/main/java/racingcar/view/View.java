package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
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
        return Integer.parseInt(tryCountInput);

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
            if (i < winners.size() - 1) {
                winnerNames.append(", ");
            }
        }

        System.out.println("최종 우승자 : " + winnerNames.toString());
    }

}
