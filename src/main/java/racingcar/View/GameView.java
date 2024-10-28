package racingcar.View;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.Model.Car;

public class GameView {


    public void showGameProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.name + " : " + "-".repeat(car.ongoingCount));
        }
        System.out.println();
    }

    public void showWinnerCars(List<Car> cars) {
        String winners = cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winners);
    }


}
