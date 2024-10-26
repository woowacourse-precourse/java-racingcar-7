package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private static final String SCAN_CARS_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String SCAN_TRY_OUT_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?";

    private static final String RACE_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String CAR_MOVEMENT_DELIMITER = " : "; // 차량 출력 구분자
    private static final String MOVEMENT_SYMBOL = "-";
    private static final String WINNER_DELIMITER = ", ";

    public void printScanCarsMessage(){
        System.out.println(SCAN_CARS_MESSAGE);
    }

    public void printTryOutCountMessage(){
        System.out.println(SCAN_TRY_OUT_COUNT_MESSAGE);
    }

    public void printMoveResultMessage() {
        System.out.println(RACE_RESULT);
    }

    public void printMovedCars(List<Car> cars) {
        for (Car car : cars) {
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
