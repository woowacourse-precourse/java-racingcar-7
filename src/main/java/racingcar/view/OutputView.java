package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String MOVING_UNIT = "-";
    private boolean isFirstRace = true;

    public void displayRaceStatus(List<Car> carList) {
        displayHeaderIfFirstRace();

        for (Car car : carList) {
            displayCarStatus(car);
        }

        System.out.println();
    }

    public void displayWinners(List<String> winnerList) {
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
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
