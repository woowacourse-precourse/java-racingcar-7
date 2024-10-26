package racingcar.domain.car;

import java.util.Arrays;
import java.util.List;
import racingcar.constant.Constant;

public class CarNames {
    private final List<String> carNames;

    public CarNames(List<String> carNames) {
        this.carNames = carNames;
    }

    public static CarNames from(String input) {
        validateInputBlank(input);
        String[] names = splitCarName(input);
        return new CarNames(Arrays.asList(names));
    }

    private static String[] splitCarName(String input) {
        String[] names = input.split(Constant.DELIMITER);
        Arrays.setAll(names, i -> names[i].trim());
        return names;
    }

    private static void validateInputBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("경주할 자동차의 이름을 입력해 주세요.");
        }
    }

    public List<String> getCarNames() {
        return carNames;
    }
}
