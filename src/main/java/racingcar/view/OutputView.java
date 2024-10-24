package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RacingCar;

public class OutputView {

    // 각 라운드 결과 출력
    public static void printRaceResults(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    public static void printWinners(List<RacingCar> winners) {
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }

    private static void printCarPosition(RacingCar car) {
        String positionDisplay = "-".repeat(car.getPosition());
        System.out.println(car.getName() + " : " + positionDisplay);
    }


}
