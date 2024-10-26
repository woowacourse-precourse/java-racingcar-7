package racingcar.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarNameValidator {
    private static final String DELIMITER = ",";

    public static List<Car> validate(String inputNames) {

        if (inputNames == null || inputNames.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 경주할 자동차 이름이 공백이 되어서는 안 됩니다.");
        }

        List<String> cars_temp = new ArrayList<>();
        return Arrays.stream(inputNames.split(DELIMITER))
                .map(token -> {
                    String trimmed = token.trim();
                    System.out.println(trimmed);
                    if (trimmed.isEmpty() || trimmed.isBlank()) {
                        throw new IllegalArgumentException("[ERROR] 경주할 자동차 이름이 공백이 되어서는 안 됩니다.");
                    } else if (trimmed.length() > 5) {
                        throw new IllegalArgumentException("[ERROR] 경주할 자동차 이름을 5자 이하로 입력해 주세요.");
                    } else if (!checkNamePattern(trimmed)) {
                        throw new IllegalArgumentException("[ERROR] 경주할 자동차 이름을 영어로만 입력해 주세요.");
                    } else if (!cars_temp.isEmpty() && cars_temp.contains(trimmed)) {
                        throw new IllegalArgumentException("[ERROR] 경주할 자동차 이름이 중복되었습니다.");
                    }
                    cars_temp.add(trimmed);
                    return new Car(trimmed);
                }).collect(Collectors.toList());
    }

    private static boolean checkNamePattern(String name) {
        int len = name.length();
        String regex = "^[a-zA-Z]{" + len + "}$";

        return Pattern.matches(regex, name);
    }

}
