package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CarNamesValidator {

    public static List<String> validate(List<String> input) {

        // 앞 뒤 공백 제거
        input = input.stream()
                .map(String::trim)
                .collect(Collectors.toList());

        if (input.size() < 2) {
            throw new IllegalArgumentException("경주 자동차는 두대 이상이어야 합니다.");
        }

        // 자동차 이름 길이 확인
        validateNameLength(input);

        // 자동차 이름 중복 확인
        validateNameDuplication(input);

        return input;
    }

    private static void validateNameLength(List<String> input) {
        for (String name : input) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
            }
        }
    }

    private static void validateNameDuplication(List<String> input) {
        Set<String> nameSet = new HashSet<>();
        for (String name : input) {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }
}
