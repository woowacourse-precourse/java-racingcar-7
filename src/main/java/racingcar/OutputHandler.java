package racingcar;

import java.util.List;

public class OutputHandler {

    private static final String MOVEMENT_INDICATOR = "-";
    private static final String STATUS_DELIMITER = " : ";
    private static final String WINNER_SEPARATOR = ", ";

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printResult(List<RacingCar> racingCars) {
        racingCars.forEach(racingCar -> System.out.println(String.join(STATUS_DELIMITER, racingCar.getCarNameValue(),
                MOVEMENT_INDICATOR.repeat(racingCar.getLocation()))));
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(WINNER_SEPARATOR, winners));
    }
}
