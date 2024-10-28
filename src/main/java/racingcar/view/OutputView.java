package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String MOVE_COUNT = "-";

    public void printResultStatement() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(List<Car> carList) {
        carList.forEach(car ->
                System.out.println(car.getName()
                        + " : "
                        + MOVE_COUNT.repeat(car.getPosition())
                )
        );
        System.out.println();
    }

    public void printFinalResult(List<String> winnerList) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }
}

