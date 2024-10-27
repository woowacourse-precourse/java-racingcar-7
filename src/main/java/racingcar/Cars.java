package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import racingcar.car.Car;

public class Cars {
    final List<Car> values;

    public Cars() {
        values = new ArrayList<>();
    }

    public Cars(List<String> names, Function<String, Car> factory) {
        values = names.stream().map(factory).toList();
    }

    public void moveAll() {
        values.forEach(Car::move);
    }

    public List<Car> getAllFarthest() {
        if (values.isEmpty()) {
            return List.of();
        }

        Car oneFarthest = values.stream().max(Car::compareTo).orElseThrow();
        return values.stream().filter(oneFarthest::isSamePosition).toList();
    }

    @Override
    public String toString() {
        return values.stream().map(Car::toString).collect(Collectors.joining("\n"));
    }
}
