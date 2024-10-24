package racingcar.service;

import racingcar.domain.Car;

import java.util.List;

public interface CarManager {
    public String SEPARATOR = ",";
    public String SEPARATOR_NAME = "쉼표";
    public String VALID_INPUT_PATTERN = "^[a-zA-Z0-9\\s]+("+SEPARATOR+"[a-zA-Z0-9\\s]+)*$";
    // 알파벳 대소문자 또는 숫자로 이뤄진 문자열과 구분자(SEPARATOR)로 구성된 패턴
    public int CarNameLength = 5;
    public List<Car> carNameInput();
}
