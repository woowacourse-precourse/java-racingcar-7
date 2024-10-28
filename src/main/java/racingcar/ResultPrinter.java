package racingcar;

import java.util.List;

public class ResultPrinter {

    public void printRoundResult(List<Car> racingCar) {
        for (Car car : racingCar) {
            String statusBar = "-".repeat(car.advance);
            System.out.println(car.name + " : " + statusBar);
        }
        System.out.println();
    }

    public void printWinners(String winners) {
        System.out.println("최종 우승자 : " + winners);
    }
}