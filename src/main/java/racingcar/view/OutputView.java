package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public void printCurrentCarPositions(final List<Car> cars) {
        for (Car car : cars) {
            StringBuilder result = new StringBuilder(car.getName() + " : ");
            int carPosition = car.getPosition();
            for (int j = 0; j < carPosition; j++) {
                result.append("-");
            }
            System.out.println(result.toString());
        }
        System.out.println();
    }

    public void printWinners(int maxPosition, final List<Car> cars) {
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
        System.out.print(String.join(", ", winners));
    }
}
