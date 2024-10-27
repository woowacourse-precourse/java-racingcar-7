package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class GameView {

    public void displayRoundResult(List<Car> cars) {
        System.out.println("실행결과");
        for (Car car : cars) {
            renderPosition(car);
        }
    }

    public String renderPosition(Car car) {
        return car.getName() + " : " + "-".repeat(car.getPosition());
    }

    public void displayWinners(List<Car> winnerCars) {
        String result = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }
}
