package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void printCarNamesInstruction() {
        System.out.println(InfoMessage.CAR_NAMES_INSTRUCTION.getMessage());
    }

    public void printMovingCountInstruction() {
        System.out.println(InfoMessage.MOVING_COUNT_INSTRUCTION.getMessage());
    }

    public void printRacingResultTitle() {
        System.out.println(InfoMessage.RESULT.getMessage());
    }

    public void printRacingResult(List<Car> carList) {
        carList.forEach(car -> System.out.printf("%s : %s%n", car.getName(), car.getPositionString()));
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.print(InfoMessage.FINAL_WINNER.getMessage());
        System.out.println(String.join(", ", winners));
    }
}
