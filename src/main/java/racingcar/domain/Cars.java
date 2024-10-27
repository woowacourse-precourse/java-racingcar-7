package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] players) {
        this.cars = Arrays.stream(players)
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public int getSize(){
        return cars.size();
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void tryMove(NumberGenerator numberGenerator) {
        cars.forEach(car -> car.move(numberGenerator.generateNumber()));
    }

    public String getWinners() {
        int maxLocation = cars.stream().map(Car::getLocation).max(Integer::compareTo).get();
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
