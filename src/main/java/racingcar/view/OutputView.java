package racingcar.view;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    public void showExecuteMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void showStatus(Cars cars) {
        for (Car car : cars.cars()) {
            showCarLocationToGauge(car);
        }
        System.out.println();
    }

    private void showCarLocationToGauge(Car car) {
        System.out.print(car.name() + " : ");
        for (int gauge = 0; gauge < car.location(); gauge++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void showWinners(List<String> winnersName) {
        String result = String.join(", ", winnersName);
        System.out.println("최종 우승자 : " + result);
    }
}
