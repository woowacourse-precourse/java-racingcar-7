package racingcar.util;

import java.util.List;
import racingcar.domain.Car;

public class RacingCarOutput {

    public void printRoundResult(List<Car> carList) {

        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinner(List<Car> carList) {

        int maxPosition = 0;
        for (Car car : carList) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        StringBuilder winner = new StringBuilder();
        for (Car car : carList) {
            if (car.getPosition() == maxPosition) {
                winner.append(car.getName()).append(", ");
            }
        }

        System.out.println("최종 우승자 : " + winner.substring(0, winner.length() - 2));
    }
}
