package racingcar.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String BLANK = "";
    private static final String SPACE = " ";
    private static final String DELIMITER = ":";
    private static final String SPLITOR = ",";

    private List<Car> cars;

    public List<Car> getClonedCars() {
        List<Car> clonedCars=cars.stream()
                .map((car)->new Car(car.getName(),car.getState()))
                .collect(Collectors.toUnmodifiableList());

        return clonedCars;
    }

    public Cars(String carsInput) {
        carsInput=CarsFactory.validateInput(carsInput);
        this.cars = makeCarList(carsInput);
    }

    private List<Car> makeCarList(String carsInput) {
        List<Car> carList = Arrays.stream(carsInput.split(SPLITOR))
                .map(carName -> new Car(carName, ""))
                .toList();

        return carList;
    }

    public void race(NumberGenerator numberGenerator) {
        cars.stream()
                .forEach(car -> car.act(numberGenerator.generateNumber()));
    }

    public void printState() {
        cars.stream()
                .forEach(car -> {
                    System.out.println(car.name + SPACE + DELIMITER + SPACE + car.state);
                });
        System.out.println(BLANK);
    }

    public String findWinners() {
        int maxDistance = findMaxDistance();

        List<Car> winnerList = filterWinners(maxDistance);

        String winnerNames = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        return winnerNames;
    }

    private List<Car> filterWinners(int maxDistance) {
        return cars.stream()
                .filter((car) -> car.getDistance() == maxDistance)
                .toList();
    }

    private int findMaxDistance() {
        Car winner = cars.stream()
                .max(Comparator.comparing(car -> car.getDistance()))
                .orElseThrow(NullPointerException::new);

        return winner.getDistance();
    }
}
