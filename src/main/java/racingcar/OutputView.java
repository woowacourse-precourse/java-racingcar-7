package racingcar;


import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void reportProgress(List<Car> raceMember) {
        for (Car car : raceMember) {
            System.out.print(car.getCarName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void reportRaceResult(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
