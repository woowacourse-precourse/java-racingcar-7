package util;

import dto.RacingInput;
import dto.RacingParam;
import java.util.ArrayList;
import repository.CarRepository;

public class Extractor {
    public static ArrayList<Car> extractCarList(String input) {
        String[] inputCars = input.split(",");
        Validator.validateInputDate(inputCars);

        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < inputCars.length; i++) {
            cars.add(new Car(inputCars[i]));
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
