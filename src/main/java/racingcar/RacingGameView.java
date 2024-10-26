package racingcar;

import java.util.List;

public class RacingGameView {
    public String generateCarStatus(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    public String generateWinnersMessage(List<String> winners) {
        return "최종 우승자 : " + String.join(", ", winners);
    }

    public void printRoundResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(generateCarStatus(car)));
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(generateWinnersMessage(winners));
    }
}