package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners;

    private Winners(List<Car> winners) {
        this.winners = winners;
    }

    public static Winners of(Cars cars) {
        List<Car> carList = cars.getCars();
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<Car> winners = carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
        return new Winners(winners);
    }

    @Override
    public String toString() {
        return "최종 우승자 : " + winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}