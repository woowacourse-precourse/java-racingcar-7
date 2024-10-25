package model;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerFinder {

    public List<Car> getWinners(List<Car> cars) {
        // TODO: max 비교할때 Java api 활용 하고싶지만 일단 구현

        int maxStep = 0;
        for (Car car : cars) {
            maxStep = Math.max(maxStep, car.getStep());
        }

        final int finalMaxStep = maxStep;

        return cars.stream()
                .filter(car -> car.getStep() == finalMaxStep)
                .collect(Collectors.toList());
    }

}
