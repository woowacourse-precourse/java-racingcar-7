package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {
    public static void printIntermediateResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getCarName() + " : ");
            printIntermediateScore(car.getScore());
            System.out.println();
        }
        System.out.println();
    }

    public static void printIntermediateText() {
        System.out.println("실행 결과");
    }

    public static void printIntermediateScore(int score) {
        for (int i = 0; i < score; i++) {
            System.out.print("-");
        }
    }

    public static void printFinalResults(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        String result = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
