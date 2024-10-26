package util;

import static validator.CarNameValidator.validateInputCars;
import static validator.RepeatCountValidator.validateInputRepeatCount;

import dto.RacingInput;
import dto.RacingParam;
import java.util.ArrayList;
import java.util.Arrays;
import repository.CarRepository;

public class Extractor {

    private static ArrayList<String> extractCarList(String input) {
        String[] splitInput = input.split(",");
        ArrayList<String> inputCars = new ArrayList<>(Arrays.asList(splitInput));
        validateInputCars(inputCars);
        return inputCars;
    }

    private static ArrayList<Car> converToCarArrayList(ArrayList<String> inputCars) {
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

    public static String extractRaceStatus(int forwardCount) {
        String forwardStatus = "";
        for (int i = 0; i < forwardCount; i++) {
            forwardStatus += "-";
        }
        return forwardStatus;
    }

    private static int extractRepeatCount(String inputRepeatCount) {
        validateInputRepeatCount(inputRepeatCount);
        return Integer.parseInt(inputRepeatCount);
    }

    public static RacingParam parseInput(RacingInput input) {
        ArrayList<Car> inputCars = converToCarArrayList(extractCarList(input.cars()));
        int inputRepeatCount = extractRepeatCount(input.repeatCount());
        return new RacingParam(inputCars, inputRepeatCount);
    }
}
