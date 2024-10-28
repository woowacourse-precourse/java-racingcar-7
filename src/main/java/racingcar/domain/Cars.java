package racingcar.domain;


import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;
    private static final int MAX_NAME_LENGTH = 5;

    public Cars(String input) {
        validateInput(input);
        List<String> names = Arrays.asList(input.split(","));
        validateNames(names);
        this.cars = createCars(names);
    }

    private void validateInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNames(List<String> names) {
        for (String name : names) {
            validateSingleName(name);
        }
    }

    private void validateSingleName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> createCars(List<String> names) {
        return names.stream()
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveAll() {
        cars.forEach(car -> {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.move(randomNumber);
        });
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
