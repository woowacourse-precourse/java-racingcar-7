package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class ConsoleOutputView implements OutputView {
    private static final String PROGRESS_MARK = "-";

    public void printMidTitle() {
        System.out.println("\n실행 결과");
    }

    public void printMidResult(List<Car> cars) {
        StringBuilder result = new StringBuilder();
        for (Car car : cars) {
            result.append(car.getName())
                    .append(" : ")
                    .append(PROGRESS_MARK.repeat(car.getLocation()))
                    .append("\n");
        }
        System.out.println(result);
    }

    public void printFinalResult(List<Car> cars) {
        int maxLocation = findMaxLocation(cars);
        List<String> winners = findWinners(cars, maxLocation);
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private int findMaxLocation(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }

    private List<String> findWinners(List<Car> cars, int maxLocation) {
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .toList();
    }
}
