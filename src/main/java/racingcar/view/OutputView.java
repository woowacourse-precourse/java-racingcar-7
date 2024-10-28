package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void printStartMessage() {
        System.out.println("실행 결과");
    }

    public void printCurrentLocationOf(Car car) {
        final String ONE_STEP = "-";
        System.out.println(car.getName() + " : " + ONE_STEP.repeat(car.getCurrentLocation()));
    }

    public void printEndOfOneRace() {
        System.out.println();
    }

    public void printWinnerNames(List<String> winnerNames) {
        System.out.print("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
