package util;

import java.util.ArrayList;
import repository.CarRepository;

public class Extractor {
    public static Car[] extractCarList(String input) {
        String[] inputCars = input.split(",");

        // 자동차 이름 유효성 검증
        for (String car : inputCars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 최대 5글자 입니다.");
            }
        }

        Car[] cars = new Car[inputCars.length];
        for (int i = 0; i < inputCars.length; i++) {
            cars[i] = new Car(inputCars[i]);
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
}
