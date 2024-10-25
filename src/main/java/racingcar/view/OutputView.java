package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

public class OutputView {
    private static final String RACE_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String CAR_MOVEMENT_DELIMITER = " : "; // 차량 출력 구분자
    private static final String MOVEMENT_SYMBOL = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void printMoveResultMessage() {
        System.out.println(RACE_RESULT);
    }

    public void printMovedCars(Cars cars) {
        for (Car car : cars.getCars()) {
            printCarMovement(car);
        }
        System.out.println();
    }

    private void printCarMovement(Car car) {
        String movement = generateCarMovementString(car);
        System.out.println(movement);
    }

    private String generateCarMovementString(Car car){
        StringBuilder movement = new StringBuilder(car.getName() + CAR_MOVEMENT_DELIMITER);
        for (int i = 0; i < car.getMovedNumber(); i++) {
            movement.append(MOVEMENT_SYMBOL);
        }
        return movement.toString();
    }

    public void printWinner(List<String> winners) {
        String winnerNames = String.join(WINNER_DELIMITER, winners);
        System.out.println(FINAL_WINNER + winnerNames);
    }
}
