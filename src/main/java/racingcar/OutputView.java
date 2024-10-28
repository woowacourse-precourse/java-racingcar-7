package racingcar;

import java.util.List;

public class OutputView {

    private static final String CAR_SYMBOL = "-";

    public static void printRacingStatus(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print(CAR_SYMBOL);
            }
            printLineBreak();
        }
    }

    public static void printLineBreak() {
        System.out.println();
    }
}