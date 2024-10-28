package racingcar.View;

import java.util.List;
import racingcar.Domain.Car;
import racingcar.ViewInterface.OutputView;

public class ConsoleOutputView implements OutputView {

    public void printRaceResult() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}