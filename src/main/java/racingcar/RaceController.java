package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceController {
    private final List<Car> cars = new ArrayList<>();

    public List<String> parseAndValidateCarNames(String input) {
        List<String> carNames = List.of(input.split(","));
        for (String name : carNames) {
            validateCarName(name.trim());
            cars.add(new Car(name.trim()));
        }
        return carNames;
    }

    private void validateCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하로 입력해야 합니다.");
        }
    }
}
