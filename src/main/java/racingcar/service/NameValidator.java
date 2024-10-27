package racingcar.service;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class NameValidator {
    int defaultNameCount = 1;
    static final String DELIMITER = ",";
    static final int NAME_LENGTH_LIMIT = 5;
    static final String VALID_PATTERN = "^[a-zA-Z0-9]+$";
    private final List<String> nameList = new ArrayList<>();
    private final List<Car> playerList = new ArrayList<>();

    public List<Car> separatePlayerList(String input) {
        String[] players = input.split(DELIMITER, -1);

        for(String playerName : players) {
            playerName = validateNameEmpty(playerName);
            validateNamePattern(playerName);
            validateNameLength(playerName);
            validateNameDuplication(playerName);

            registerCar(playerName);
        }

        return playerList;
    }

    private void registerCar(String name) {
        Car car = new Car(name);
        playerList.add(car);
    }

    private String validateNameEmpty(String name) {
        if(name.isEmpty()) {
            name = "car" + (defaultNameCount++);
        }

        return name;
    }

    private void validateNamePattern(String name) {
        if(!name.matches(VALID_PATTERN)) {
            throw new IllegalArgumentException(
                "각 차의 이름은 숫자와 영어로만 구성되어야 합니다 : " + name
            );
        }
    }

    private void validateNameLength(String name) {
        if(name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(
                "각 차의 이름은 " + NAME_LENGTH_LIMIT + "자를 넘길 수 없습니다 : " + name
            );
        }
    }

    private void validateNameDuplication(String name) {
        if(nameList.contains(name)) {
            throw new IllegalArgumentException(
                "참가자들의 차 이름은 모두 다르게 등록되어야 합니다 : " + name
            );
        }

        nameList.add(name);
    }
}
