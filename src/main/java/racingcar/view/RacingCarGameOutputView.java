package racingcar.view;

import java.util.List;
import racingcar.model.Cars;

public class RacingCarGameOutputView {

    private RacingCarGameOutputView() {
    }

    public static void printExecutionResultHeader() {
        System.out.println();
        System.out.println("실행결과");
    }

    public static void printCarPositions(Cars cars) {
        cars.getCars().forEach(car -> {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        });
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}