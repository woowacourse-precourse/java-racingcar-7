package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RacingCar;

public class OutputView {

    public void printResultHeader() {
        System.out.println(ViewMessage.RESULT_HEADER.getMessage());
    }

    public void printRaceResults(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            printCarPosition(car);
        }
        System.out.println();
    }

    public void printWinners(List<RacingCar> winners) {
        String winnerNames = winners.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        System.out.println(ViewMessage.FINAL_WINNER.getMessage() + winnerNames);
    }

    private void printCarPosition(RacingCar car) {
        String positionDisplay = "-".repeat(car.getPosition());
        System.out.println(car.getName() + " : " + positionDisplay);
    }

}
