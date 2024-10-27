package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.model.Winners;

public class OutputView {

    public static void display(Cars cars) {
        cars.getCars().forEach(car -> {
            String name = car.getName();
            int distance = car.getDistance();

            System.out.print(name + " : ");
            System.out.println("-".repeat(distance));
        });
        System.out.println();
    }

    public void displayWinners(Winners winners) {
        List<Car> winnerCars = winners.getWinners();

        String winnerNames = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }
}
