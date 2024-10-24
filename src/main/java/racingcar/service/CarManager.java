package racingcar.service;

import racingcar.domain.Car;

import java.util.List;

public interface CarManager {
    String SEPARATOR = ",";
    String SEPARATOR_NAME = "쉼표";
    String VALID_INPUT_PATTERN = "^[a-zA-Z0-9]+("+SEPARATOR+"[a-zA-Z0-9]+)*$";
    // 알파벳 대소문자 또는 숫자로 이뤄진 문자열과 구분자(SEPARATOR)로 구성된 패턴
    int CarNameLength = 5;
    public List<Car> carNameInput();
}
