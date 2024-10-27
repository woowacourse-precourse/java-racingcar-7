package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarRace;

import java.util.List;
import java.util.stream.Collectors;

public class CarOutput {

    public static void outputTitle() {
        System.out.println("실행 결과");
    }

    public static void outputResultPerRap(CarRace carRace) {
        for(Car car : carRace.getCars()) {
            final String name = car.getName().getName();
            final String position = visualizePosition(car.getPosition());

            System.out.printf("%s : %s\n", name, position);
        }
        System.out.println();
    }

    public static void outputWinnersName(List<Car> winners) {
        final String winnersString = joinWinners(winners);
        System.out.println(winnersString);
    }

    private static String visualizePosition(int position) {
        return "-".repeat(Math.max(0, position));
    }

    private static String joinWinners(List<Car> winners) {
        return winners.stream()
                .map(car -> car.getName().getName())
                .collect(Collectors.joining(", "));
    }
}
