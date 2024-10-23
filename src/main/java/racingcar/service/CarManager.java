package racingcar.service;

import racingcar.domain.Car;

import java.util.List;

public interface CarManager {
    String SEPARATOR = ",";
    String SEPARATOR_NAME = "쉼표";
    String VALID_INPUT_PATTERN = "^\\d+("+SEPARATOR+"\\d+)*$";
    Integer CarNameLength = 5;
    public List<Car> carNameInput();
}
