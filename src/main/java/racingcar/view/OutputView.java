package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    public void printGameStart() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s%n",
                    car.getCarName(), "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
