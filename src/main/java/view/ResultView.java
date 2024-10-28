package view;

import java.util.List;
import model.Car;

public class ResultView {
    public static void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = String.join(", ", winners.stream().map(Car::getName).toList());
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
