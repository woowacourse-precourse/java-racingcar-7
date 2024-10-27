package racingcar.service;

import racingcar.model.Car;
import racingcar.util.PlayerNameValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarService {
    private final PlayerNameValidator playerNameValidator

    public CarService(PlayerNameValidator playerNameValidator) {
        this.playerNameValidator = playerNameValidator;
    }

    public List<Car> playRounds(String playersName, int moveCount) {
        List<String> names = splitByComma(playersName);
        playerNameValidator.validateName(names);

        List<Car> cars = carGenerator(names);

    }

    public List<String> splitByComma(String input) {
        return Arrays.asList(input.split(","));
    }


    private List<Car> carGenerator(List<String> names){
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name)); // 이름으로 Car 객체 생성
        }
        return cars;
    }
}
