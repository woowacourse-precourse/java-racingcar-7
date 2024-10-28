package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.model.Car;

// 결과를 출력하는 클래스
public class Output {
    private static final String CAR_POSITION_RESULT_FORMAT = "%s : %s";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : %s";
    private static final String CAR_NAME_DELIMITER = ", ";

    // 경주 결과를 출력하는 메서드
    public void printRaceResults(List<Car> cars) {
        cars.forEach(car -> {
            System.out.printf(CAR_POSITION_RESULT_FORMAT, car.getName(), "-".repeat(car.getPosition()));
            System.out.println();
        });
        System.out.println();
    }

    // 우승자를 출력하는 메서드
    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream().map(Car::getName).collect(Collectors.joining(CAR_NAME_DELIMITER));
        System.out.printf(FINAL_WINNER_MESSAGE, winnerNames);
    }
}
