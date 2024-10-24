package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public void printRoundResult(int roundNumber, List<Car> carList) {
        System.out.println("실행 결과");
        carList.forEach(car ->
                System.out.println(car.getName()
                        + " :"
                        + "-".repeat(car.getPosition())
                )
        );
        System.out.println();
    }
}

