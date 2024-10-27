package service;

import static constant.GameConstants.NAME_SEPARATOR;

import model.Car;
import repository.CarRepository;
import validators.CarValidator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarSetService {

    public List<Car> getCars(String input) {
        String[] carNames = parseCarNames(input);
        List<Car> cars = createCars(carNames);
        saveCars(cars);
        return cars;
    }

    private String[] parseCarNames(String input) {
        return input.split(NAME_SEPARATOR.getMessage());
    }

    private List<Car> createCars(String[] carNames) {
        Set<String> uniqueNames = new HashSet<>();
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            String trimmedName = name.trim();
            CarValidator.validateCarName(trimmedName, uniqueNames);
            cars.add(new Car(trimmedName));
        }
        return cars;
    }

    private void saveCars(List<Car> cars) {
        CarRepository.addCars(cars);
    }
}
