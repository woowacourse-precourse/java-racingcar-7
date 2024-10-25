package racingcar.validator;

import java.util.HashSet;
import java.util.Set;
public class CarNamesValidator {

    public static String[] validate(String[] input) {

        if (input.length < 2) {
            throw new IllegalArgumentException("경주 자동차는 두대 이상이어야 합니다.");
        }

        // 자동차 이름 길이 확인
        validateNameLength(input);

        // 자동차 이름 중복 확인
        validateNameDuplication(input);


        return input;
    }

    private static void validateNameLength(String[] input) {
        for (String name:input) {
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException(("자동차 이름은 1자 이상, 5자 이하만 가능합니다."));
            }
        }
    }

    private static void validateNameDuplication(String[] input) {
        Set<String> nameSet = new HashSet<>();
        for (String name : input) {
            if (!nameSet.add(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
        }
    }
}
