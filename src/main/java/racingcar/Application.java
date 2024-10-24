package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println(IOMessage.INPUT_CAR_NAMES);
        String carNames = readLine();

        System.out.println(IOMessage.INPUT_TRY_COUNT);
        String tryCount = readLine();

        isValidName(carNames);
    }

    public static boolean isValidName(String carNames) {
        validateStartEnd(carNames);

        String[] namesByComma = carNames.split(IOMessage.COMMA_SEPARATOR);
        validateDuplication(namesByComma);

        for (String name : namesByComma) {
            validateEmpty(name);
            validateLength(name);
        }

        return true;
    }

    public static void validateStartEnd(String carNames) {
        if (carNames.startsWith(",") || carNames.endsWith(",")) {
            throw new IllegalArgumentException("맨 앞 또는 뒤 이름이 없다.");
        }
    }

    public static void validateDuplication(String[] namesByComma) {
        Set<String> names = new HashSet<>(Arrays.stream(namesByComma).toList());

        if (namesByComma.length != names.size()) {
            throw new IllegalArgumentException("중복된 이름을 사용했다.");
        }
    }

    public static void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름 길이가 5를 초과했다.");
        }
    }

    public static void validateEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("빈 값이다.");
        }
    }
}
