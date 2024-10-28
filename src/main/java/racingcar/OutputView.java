package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printInfo() {
        System.out.println("실행 결과");
    }

    public void printRound(List<Car> cars) {
        cars.forEach(this::printRound);
        System.out.println();
    }

    private void printRound(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    public void printWinner(Car winner) {
        System.out.println("최종 우승자 : " + winner.getName());
    }

    public void printWinner(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
