package racingcar.view;

import racingcar.model.Car;

public class OutputView {
    public static void printCarPosition(Car[] cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + " - ".repeat(car.getPosition()));
        }
    }

    public static void printWinner(String winnerCar) {
        System.out.println("최종 우승자 : " + winnerCar);
    }
}
