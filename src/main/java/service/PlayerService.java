package service;

import java.util.Arrays;
import java.util.List;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarValidator;

public class PlayerService {

    private static final String DELIMITER = ",";

    public List<RacingCar> registerPlayers(String carNames) {
        List<String> carNameList = parseCarNames(carNames);
        List<RacingCar> players = carNameList.stream().map(RacingCar::new).toList();

        RacingCarValidator.validate(players);

        return players;
    }

    private List<String> parseCarNames(String carNames) {
        return Arrays.stream(carNames.split(DELIMITER)).map(this::preProcess).toList();
    }

    private String preProcess(String carName) {
        return carName.trim();
    }
}
