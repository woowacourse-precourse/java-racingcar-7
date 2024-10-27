package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.model.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    final InputView inputView = new InputView();
    final OutputView outputView = new OutputView();
    int attempts;
    List<Car> cars = new ArrayList<>();

    public RacingController() {
    }

    public void run() {
        setCars(inputView.getCarNamesInput());
        setAttempts(inputView.getAttempts());

        outputView.printStartMessage();
        IntStream.range(0, attempts).forEach(i -> playOneRace());

        outputView.printWinnerNames(getWinnerNames());
    }

    public List<String> getWinnerNames() {
        return cars.stream()
            .filter(car -> car.getCurrentLocation() == getMaxCurrentLocation())
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    public int getMaxCurrentLocation() {
        return cars.stream().mapToInt(Car::getCurrentLocation).max().orElse(0);
    }

    public void playOneRace() {
        for (Car car : cars) {
            car.move();
            outputView.printCurrentLocationOf(car);
        }
        outputView.printEndOfOneRace();
    }

    public void setCars(String input) {
        List<String> carNames = getDuplicationCheckedCarNamesFrom(input);
        for (String carName : carNames) {
            this.cars.add(new Car(getValidated(carName)));
        }
    }

    public List<String> getDuplicationCheckedCarNamesFrom(String input) {
        List<String> names = Arrays.stream(input.split(",")).map(String::trim).toList();

        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차 이름을 입력할 수 없습니다. ");
        }

        return names;
    }

    public String getValidated(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 공백이 될 수 없습니다. ");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다. ");
        }
        return name;
    }

    public void setAttempts(String input) {
        try {
            this.attempts = Integer.parseInt(input);

            if (attempts <= 0) {
                throw new IllegalArgumentException("시도할 횟수는 양수만 입력 가능합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자만 입력 가능합니다. ");
        }
    }
}
