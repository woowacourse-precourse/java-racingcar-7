package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceOutput {

    public static void displayRaceResults(List<Car> cars, int numberOfAttempts) {
        System.out.println("실행결과");

        for (int i = 1; i <= numberOfAttempts; i++) {
            for (Car car : cars) {
                displayCarMovement(car, i);
            }
            System.out.println();
        }
    }

    private static void displayCarMovement(Car car, int attempt) {
        System.out.print(car.getName() + " : ");
        System.out.println(getMovementLog(car, attempt));
    }

    private static String getMovementLog(Car car, int attempt) {
        List<String> movements = new ArrayList<>();

        List<CarMovementState> movementStates = car.getMovementLog(attempt);

        for (CarMovementState status : movementStates) {
            if (status == CarMovementState.MOVE) {
                movements.add("-");
            } else {
                movements.add("");
            }
        }

        return String.join("", movements);
    }

    public static void displayWinners(List<Car> cars) {
        List<String> winners = determineWinners(cars);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private static List<String> determineWinners(List<Car> cars) {
        int maxMoveCount = cars.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}