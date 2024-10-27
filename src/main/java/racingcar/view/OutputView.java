package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    public static void promptCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void promptTrialCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public static void displayResultHeader() {
        System.out.println("실행 결과");
    }

    public static void displayRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void displayWinners(List<String> winnerNames) {
        String winnerNamesStr = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : " + winnerNamesStr);
    }
}
