package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.Optional;

public class Cars {
    private final List<Car> cars;

    public Cars(String carNames) {
        validateInput(carNames);
        this.cars = createCars(carNames);
    }

    private void validateInput(String carNames) {
        String[] names = carNames.split(",");
        Set<String> uniqueNames = new HashSet<>();

        for (String name : names) {
            String trimmedName = name.trim();

            if(!trimmedName.matches("^[a-zA-Z0-9]+$")) {
                throw new IllegalArgumentException();
            }

            if(!uniqueNames.add(trimmedName)) {
                throw new IllegalArgumentException();
            }
        }
    }


    public List<Car> createCars(String inputNames) {
        String[] names = inputNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            Car car = new Car(name.trim());
        }
        return cars;
    }

    public void runCars() {
        for (Car car : cars) {
            car.run(generateRandomNumber());
        }
    }

    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<>();
        Optional<Integer> maxDistance = getMaxDistance();

        cars.stream().filter(car -> car.getDistance() == maxDistance.orElse(0)).forEach(winners::add);

        return winners;
    }

    public List<Car> getCars() {
        return cars;
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(Rule.MIN_NUMBER.value(), Rule.MAX_NUMBER.value());
    }

    private Optional<Integer> getMaxDistance() {
        return cars.stream().map(Car::getDistance).max(Comparator.naturalOrder());
    }

}
