package racingcar.io;

import java.util.List;
import racingcar.Car;

public class OutputHandler {

    public void printTrialResult(List<Car> cars) {
        System.out.println("실행 결과:");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void printFinalWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
