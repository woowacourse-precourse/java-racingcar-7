package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    private static final Pattern RACING_CAR_NAME_REGEX_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]{0,4}$");

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String racingCarNameInput = inputString("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> racingCars = Arrays.asList(racingCarNameInput.split(","));
        validateRacingCars(racingCars);
    }

    private static String inputString() {
        return inputString(null);
    }

    private static String inputString(String message) {
        if (message == null) {
            return Console.readLine();
        }
        System.out.println(message);
        return Console.readLine();
    }

    private static void validateRacingCars(List<String> racingCars) {
        if (racingCars.size() != new HashSet<>(racingCars).size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 존재합니다.");
        }
        racingCars.forEach(Application::validateRacingCar);
    }

    private static void validateRacingCar(String racingCar) {
        if (!RACING_CAR_NAME_REGEX_PATTERN.matcher(racingCar).matches()) {
            throw new IllegalArgumentException("자동차 이름은 영문자로 시작하고, 영문자와 숫자로만 구성되어야 하며, 5글자 이하여야 합니다.");
        }
    }
}
