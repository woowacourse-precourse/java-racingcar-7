package racingcar.io;

import racingcar.racing.Car;
import java.util.List;

public class Output {
    public void printRaceResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : " + "-".repeat(car.getPosition()));
            System.out.println();
        }

        System.out.println();
    }

    public void printWinner(List<String> winners) {
        String winner = String.join(", ", winners);
        System.out.print("최종 우승자 : " + winner);
    }
}
