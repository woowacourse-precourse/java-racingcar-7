package racingcar.view;

import java.util.ArrayList;
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

    public void printRacingResult(ArrayList<Car> carList) {

        for (Car car : carList) {
            System.out.printf("%s : %s%n", car.getName(), car.getPositionString());
        }

        System.out.println();
    }
}
