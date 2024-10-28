package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String MOVING_UNIT = "-";
    private boolean isFirstRace = true;

    public void displayRaceStatus(List<Car> cardList) {
        displayHeaderIfFirstRace();

        for (Car car : cardList) {
            displayCarStatus(car);
        }

        System.out.println();
    }

    private void displayHeaderIfFirstRace() {
        if (isFirstRace) {
            System.out.println("\n실행 결과");
            isFirstRace = false;
        }
    }

    private void displayCarStatus(Car car) {
        System.out.print(car.getName() + " : ");
        displayMovingUnits(car.getDistance());
        System.out.println();
    }

    private void displayMovingUnits(int distance) {
        while (distance-- > 0) {
            System.out.print(MOVING_UNIT);
        }
    }
}
