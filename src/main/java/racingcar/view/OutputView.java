package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void showExecuteMessage() {
        System.out.println("실행 결과");
    }

    public void showStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.name() + " : ");
            for (int j = 0; j < car.status(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void showWinners(List<String> winnersName) {
        String result = String.join(", ", winnersName);
        System.out.println("최종 우승자 : " + result);
    }
}
