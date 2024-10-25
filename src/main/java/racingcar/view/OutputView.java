package racingcar.view;

import java.util.List;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.model.Race;

public class OutputView {

    public void printResultStart() {
        System.out.println("실행 결과");
    }

    public void printRaceStatus(Race race) {
        List<Car> cars = race.getCars();
        cars.forEach(this::printCarStatus);
        System.out.println();
    }

    private void printCarStatus(Car car) {
        System.out.printf("%s : %s\n", car.getName(), formatLocation(car));
    }

    private String formatLocation(Car car) {
        StringBuilder sb = new StringBuilder();
        int count = car.getLocation();
        IntStream.range(0, count).forEach(i -> sb.append("-"));
        return sb.toString();
    }

    public void printWinners(Race race) {
        System.out.printf("최종 우승자 : %s", formatWinners(race));
    }

    private String formatWinners(Race race) {
        List<String> names = race.findWinners()
                .stream()
                .map(Car::getName)
                .toList();
        return String.join(", ", names);
    }
}
