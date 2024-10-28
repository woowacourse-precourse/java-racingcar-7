package controller;


import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import model.Car;
import service.CarService;
import view.CarView;

public class CarController {
    private final CarService carService = new CarService();
    private final CarView carView = new CarView();

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
            String carName = tokenizer.nextToken();
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
        return Integer.parseInt(numberOfRace);
    }

    public void runRaces(List<Car> cars, int raceCount) {
        for (int i = 0; i < raceCount; i++) {
            carService.assignRandomValueToAllCars(cars);

            System.out.println();
        }
    }

    public void displayWinners(List<Car> cars) {
        List<Car> winners = carService.findWinners(cars);
        carView.showWinners(winners);
    }
}

