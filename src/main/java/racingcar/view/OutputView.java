package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void printCurrentStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }


    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    public void printResult() {
        System.out.println("\n실행 결과");
    }
}
