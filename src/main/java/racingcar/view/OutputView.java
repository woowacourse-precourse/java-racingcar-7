package racingcar.view;

import java.util.List;
import racingcar.dto.CarNameDto;
import racingcar.model.Car;

public class OutputView {
    private static final int SOLO_WINNER = 1;
    private static final int LAST_COMMA_COUNT = 2;

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printNewline() {
        System.out.println();
    }

    public void printAllCarMovement(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(printEachCarMovement(car));
        }
    }

    public void printWinners(List<CarNameDto> winnerCars) {
        StringBuilder nameOfWinnerCars = new StringBuilder();

        if (isSoleWinner(winnerCars)) {
            System.out.println("최종 우승자 : " + nameOfWinnerCars.append(winnerCars.get(0).name()));

            return;
        }

        for (CarNameDto car : winnerCars) {
            nameOfWinnerCars.append(car.name()).append(", ");
        }

        nameOfWinnerCars.deleteCharAt(nameOfWinnerCars.length() - LAST_COMMA_COUNT);
        System.out.println("최종 우승자 : " + nameOfWinnerCars);
    }

    private String printEachCarMovement(Car car) {
        return car.getName() + " : " + printPosition(car.getPosition());
    }

    private String printPosition(int movementNumber) {
        return "-".repeat(Math.max(0, movementNumber));
    }

    private boolean isSoleWinner(List<CarNameDto> winnerCars) {
        return winnerCars.size() == SOLO_WINNER;
    }

}
