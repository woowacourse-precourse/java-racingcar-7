package racingcar.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Cars {
    private final Set<Car> cars;

    public Cars(String[] players) {
        this.cars = Arrays.stream(players)
                .map(Car::new)
                .collect(Collectors.toUnmodifiableSet());
    }

    public int getSize(){
        return cars.size();
    }

    public Set<Car> getCars() {
        return new HashSet<>(cars);
    }

    public void tryMove(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generateNumber()));
    }
}
