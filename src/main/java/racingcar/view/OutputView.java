package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {

    public void printCarNameInputPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputAttempsPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResultPrompt() {
        System.out.println("실행 결과");
    }

    public static void showRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            String progress = "-".repeat(car.getDistance());
            System.out.println(car.getName() + " : " + progress);
        }
        System.out.println();
    }

    public void showWinners(List<Car> winners) {
        String result = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }
}
