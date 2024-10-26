package util;

import dto.RacingInput;
import dto.RacingParam;
import java.util.ArrayList;
import java.util.Arrays;
import repository.CarRepository;

public class Extractor {

    public static ArrayList<String> extractCarList(String input) {
        String[] splitInput = input.split(",");
        ArrayList<String> inputCars = new ArrayList<>(Arrays.asList(splitInput));
        Validator.validateInputDate(inputCars);
        return inputCars;
    }

    public static ArrayList<Car> converToCarArrayList(ArrayList<String> inputCars) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String inputCar : inputCars) {
            cars.add(new Car(inputCar));
        }
        return cars;
    }

    private static int extractMaxDistance() {
        int maxDistance = 0;
        for (Car car : CarRepository.cars) {
            if (car.getForwardCount(CarRepository.repeatCount) > maxDistance) {
                maxDistance = car.getForwardCount(CarRepository.repeatCount);
            }
        }
        return maxDistance;
    }

    public static ArrayList<String> extractWinningCarList() {
        int maxDistance = extractMaxDistance();
        ArrayList<String> winningCars = new ArrayList<>();
        for (Car car : CarRepository.cars) {
            if (car.getForwardCount(CarRepository.repeatCount) == maxDistance) {
                winningCars.add(car.getName());
            }
        }
        return winningCars;
    }

    public static RacingParam parseInput(RacingInput input) {
        ArrayList<Car> inputCars = converToCarArrayList(extractCarList(input.cars()));
        int inputRepeatCount = Integer.parseInt(input.repeatCount());
        return new RacingParam(inputCars, inputRepeatCount);
    }
}
