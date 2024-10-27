package racingcar;

import java.util.List;

public class OutputView {
    public static void printRacingResult(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.toString());
        }

        System.out.println();
    }

    public static void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(",", winner));
    }
}
