package racingcar.model;

import java.util.Arrays;
import java.util.List;

public class CarNamesParser {

    private final List<String> carNames;

    public CarNamesParser(String carNamesInput) {
        this.carNames = parseCarNames(carNamesInput);
    }

    private List<String> parseCarNames(String carNamesInput) {
        String[] namesArray = carNamesInput.split(",");
        return Arrays.asList(namesArray);  // 중복 제거
    }

    public List<String> getCarNames() {
        return carNames;
    }
}