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
        // 최대 전진 자동차의 포지션(전진 횟수)을 통해 그외의 최대 전진 자동차 전부 찾기, 출력
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
        System.out.print(String.join(", ", winners));
    }
}
