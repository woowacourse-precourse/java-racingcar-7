package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        System.out.println(" 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars_name = getCarsName();

    }

    public static List<String> getCarsName() {
        String input = Console.readLine();

        // 빈 문자열 예외 처리
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 문자열일 수 없다.");
        }
        // 이름 분리
        List<String> carNames = List.of(input.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    public static void validateCarNames(List<String> carNames) {
        Set<String> nameSet = new HashSet<>();

        for (String name : carNames) {
            name = name.trim();
            // 개별 이름이 빈 문자열일 경우 예외 처리
            if (name.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름에 빈 이름이 포함될 수 없다.");
            }

            // 이름이 5자를 초과할 경우 예외 처리
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없다 ");
            }

            // 중복된 이름 예외 처리
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없다");
            }
        }
    }
}


