package racingcar.model.car;

import racingcar.model.name.Name;
import racingcar.strategy.Strategy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    private final List<Car> cars;

    public Cars(String names) {
        this(parse(split(names)));
    }

    public Cars(String[] names) {
        this(parse(names));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private static String[] split(String names) {
        return names.split(",");
    }

    private static List<Car> parse(String[] names) {
        return Arrays.stream(names).map(Car::new).collect(Collectors.toList());
    }

    public void repeatMove(int count, Strategy strategy) {
        IntStream.range(0, count)
                .forEach(i -> move(strategy));
    }

    private void move(Strategy strategy) {
        cars.forEach(car -> car.move(strategy));
    }

    public List<Car> getCars() {
        return this.cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars1 = (Cars) o;
        return Objects.equals(cars, cars1.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars);
    }

}
