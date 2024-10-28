package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import racingcar.model.Car;
import racingcar.service.CarService;
import racingcar.view.CarView;

public class CarController {
    private final CarService carService;
    private final CarView carView;

    public CarController() {
        this.carService = new CarService();
        this.carView = new CarView();
    }

    public void run() {
        List<Car> cars = inputCarNames();
        int raceCount = inputRaceCount();
        runRaces(cars, raceCount);
        displayWinners(cars);
    }

    private List<Car> inputCarNames() {
        carView.showInputCarNamesMessage();
        String carNamesInput = carView.readCarNames();
        return createCars(carNamesInput);
    }

    public List<Car> createCars(String carNamesInput) {
        List<Car> cars = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(carNamesInput, ",");

        while (tokenizer.hasMoreTokens()) {
            String carName = tokenizer.nextToken().trim();
            validateCarName(carName);
            cars.add(new Car(carName));
        }

        return cars;
    }

    private void validateCarName(String carName) {
        if (carName.length() >= 6) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
        }
    }

    public int inputRaceCount() {
        carView.showInputRaceCountMessage();
        String numberOfRace = carView.readRaceCount();
        int raceCount = parseRaceCount(numberOfRace);
        validateRaceCount(raceCount);
        return raceCount;
    }

    private int parseRaceCount(String numberOfRace) {
        try {
            double value = Double.parseDouble(numberOfRace);
            if (value != (int) value) {
                throw new IllegalArgumentException("소수점이 있는 숫자는 허용되지 않습니다.");
            }
            return (int) value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 된 이동 횟수를 입력해주세요.");
        }
    }

    private void validateRaceCount(int raceCount) {
        if (raceCount < 1 || raceCount > 50) {
            throw new IllegalArgumentException("1부터 50 사이의 값을 입력해 주세요.");
        }
    }

    public void runRaces(List<Car> cars, int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            carService.assignRandomValueToAllCars(cars);
            System.out.println(); // 라운드 간 구분을 위한 줄바꿈
        }
    }

    public void displayWinners(List<Car> cars) {
        List<Car> winners = carService.findWinners(cars);
        carView.showWinners(winners);
    }
}
