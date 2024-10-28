package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
        }

        validateDelimiter(input);
        List<String> carNames = Arrays.asList(input.split(","));
        validateCarNames(carNames);
        validateDuplicateNames(carNames); // 중복 검사 추가
        return carNames;
    }

    public static int getAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return parseAttempts(input); // 유효성 검사 로직 분리
    }

    // 입력된 시도 횟수를 숫자로 변환하고 유효성 검사
    public static int parseAttempts(String input) {
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }

    // 구분자 유효성 검사
    public static void validateDelimiter(String input) {
        if (input.contains(";") || input.contains(":") || input.contains("/") ||
                input.matches(".*[!@#$%^&*()_+=|<>?{}\\[\\]~`].*")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로만 구분해야 합니다.");
        }
    }

    // 중복된 이름 검사
    public static void validateDuplicateNames(List<String> carNames) {
        long distinctCount = carNames.stream().distinct().count();
        if (distinctCount != carNames.size()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    // 자동차 이름 유효성 검사
    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}