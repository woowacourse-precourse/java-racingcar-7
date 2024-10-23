package racingcar.service;

import java.util.List;

public interface CarManager {
    String SEPARATOR = ",";
    String SEPARATOR_NAME = "쉼표";
    String VALID_INPUT_PATTERN = "^\\d+("+SEPARATOR+"\\d+)*$";
    public List<String> carNameInput();
}
