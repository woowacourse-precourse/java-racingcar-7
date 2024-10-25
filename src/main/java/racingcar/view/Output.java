package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.model.Car;

// 게임 결과를 출력하는 클래스
public class Output {
    private static final String WINNER_MESSAGE = "최종 우승자 : %s";

    // 경주 결과를 출력하는 메서드
    public void printRaceResults(List<Car> cars) {
        cars.forEach(car -> {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        });
        System.out.println();  // 차수 결과 구분을 위해 빈 줄 추가
    }

    // 우승자를 출력하는 메서드
    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.printf(WINNER_MESSAGE, winnerNames);
    }
}
