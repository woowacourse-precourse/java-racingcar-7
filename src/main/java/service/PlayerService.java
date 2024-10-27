package service;

import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarValidator;

public class PlayerService {

    private static final String COMMA = ",";

    public List<Car> registerPlayers(String carNames) {
        List<String> carNameList = parseCarNames(carNames);
        List<Car> players = carNameList.stream().map(Car::new).toList();

        CarValidator.validate(players);

        return players;
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(COMMA)).map(this::preProcess).toList();
    }

    private String preProcess(String carName) {
        return carName.trim();
    }
}
