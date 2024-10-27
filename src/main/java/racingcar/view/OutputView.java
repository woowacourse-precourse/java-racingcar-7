package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public void printRaceStatus(List<Car> cars){
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
    public void printWinners(List<String> winners){
        System.out.println("우승자: " + String.join(",", winners));
    }
}
