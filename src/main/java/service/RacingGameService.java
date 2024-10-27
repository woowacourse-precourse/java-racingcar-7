package service;

import exception.ErrorMessage;
import model.Car;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingGameService {

    private final static int MAX_NAME_LENGTH = 5;
    private final static int MIN_RANDOM_NUMBER = 0;
    private final static int MAX_RANDOM_NUMBER = 9;
    private final static int STANDARD_NUMBER = 4;

    public List<Car> splitCarsName(String carsName){
        String[] names = carsName.split(",",-1);
        validationName(names);
        return Arrays.stream(names)
                .map(String::trim)
                .map(Car::new)
                .toList();
    }

    public int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }

    public void racing(List<Car> cars){
        for (Car car : cars) {
            int randomNum = getRandomNumber();
            if(randomNum >= STANDARD_NUMBER){
                car.moveForward();
            }
        }
    }

    public List<String> findWinners(List<Car> cars){
        int max = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(Car -> Car.getPosition() == max).map(Car::getName)
                .collect(Collectors.toList());
    }

    public void validationName(String[] names){
        Set<String> nameSet = new HashSet<>();
        for (String name : names) {
            if (name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.NAME_LENGTH_EXCESS.getErrorMessage());
            }
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(ErrorMessage.NAME_EMPTY.getErrorMessage());
            }
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException(ErrorMessage.NAME_DUPLICATE.getErrorMessage());
            }
        }
    }

    public int validationRange(int attempts){
        if(attempts <= 0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_ATTEMPTS_RANGE.getErrorMessage());
        }
        return attempts;
    }
}
