package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void printRoundResultsHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void printWinner(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}
