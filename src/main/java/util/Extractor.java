package util;

import dto.RacingInput;
import dto.RacingParam;
import java.util.ArrayList;
import java.util.Arrays;
import repository.CarRepository;

public class Extractor {
    public static ArrayList<Car> extractCarList(String input) {
        String[] splitInput = input.split(",");
        ArrayList<String> inputCars = new ArrayList<>(Arrays.asList(splitInput));
        Validator.validateInputDate(inputCars);
        return converToCarArrayList(inputCars);
    }

    private static ArrayList<Car> converToCarArrayList(ArrayList<String> inputCars) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String inputCar : inputCars) {
            cars.add(new Car(inputCar));
        }
        return cars;
    }

    private static int returnMax() {
        int max = 0;
        for (Car car : CarRepository.cars) {
            if (car.getForwardCount(CarRepository.repeatCount) > max) {
                max = car.getForwardCount(CarRepository.repeatCount);
            }
        }

        return max;
    }

    public static ArrayList<String> extractWinningCarList() {
        int max = returnMax();
        ArrayList<String> winningCars = new ArrayList<>();

        for (Car car : CarRepository.cars) {
            if (car.getForwardCount(CarRepository.repeatCount) == max) {
                winningCars.add(car.getName());
            }
        }

        return winningCars;
    }

    public static RacingParam parseInput(RacingInput input) {

        ArrayList<Car> inputCars = Extractor.extractCarList(input.cars());
        int inputRepeatCount = Integer.parseInt(input.repeatCount());

        return new RacingParam(inputCars, inputRepeatCount);
    }
}
