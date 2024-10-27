package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {

    public static void printResultText() {
        System.out.println("\n실행 결과");
    }
    public static void printResult (Cars cars) {
        List<Car> carList = cars.getCarList();
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.print("최종 우승자 : " + winnerNames);
    }
}
