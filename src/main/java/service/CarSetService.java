package service;

import static constant.Separator.DISTINGUISHED_MESSAGE;

import java.util.HashSet;
import java.util.Set;
import model.Car;
import repository.CarRepository;
import validators.CarValidator;

public class CarService {

    public static void getCars(String input) {
        String[] carNames = input.split(DISTINGUISHED_MESSAGE.getMessage());
        Set<String> uniqueNames = new HashSet<>();
        CarRepository.clearCars();

        for (String name : carNames) {
            name = name.trim();
            CarValidator.validateCarName(name, uniqueNames);
            CarRepository.addCar(new Car(name));
        }
    }
}
