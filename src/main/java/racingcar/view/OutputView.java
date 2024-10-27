package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private OutputView() {
    }

    public static void printRaceStart() {
        System.out.println("\n실행 결과");
    }

    public static void printRaceProgress(List<Car> cars) {
        cars.forEach(OutputView::printCarPosition);
        System.out.println();
    }

    public static void printWinners(List<String> winners) {
        final String winnersText = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s%n", winnersText);
    }

    private static void printCarPosition(Car car) {
        System.out.printf("%s : %s%n", car.getName(), "-".repeat(car.getPosition()));
    }
}
