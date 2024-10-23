package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public class OutputView {

    public void executionResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void currentStatusMessage(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void finalWinnerMessage(List<String> winners) {
        String message = "최종 우승자 : " + winners.get(0);
        if (winners.size() > 1) {
            message += ", " + String.join(", ", winners.subList(1, winners.size()));
        }
        System.out.println(message);
    }


}
