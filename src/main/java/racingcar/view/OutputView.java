package racingcar.view;

import racingcar.controller.RacingGameController;
import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void  printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getSymbol());
        }
        System.out.println();
    }

    public static void printWinner(List<Car> cars) { // Winner 객체를 매개변수로 받음
        List<String> winners = RacingGameController.getWinner(cars);
        if (!winners.isEmpty()) {
            System.out.println("최종 우승자 : " + String.join(", ", winners));
        } else {
            System.out.println("최종 우승자 : ");
        }
    }

}
