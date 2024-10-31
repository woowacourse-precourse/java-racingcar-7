package racingcar.util;

import java.util.Set;

public class Validator {
    public static void validateCarName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("차 이름은 공백일 수 없습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("차 이름의 글자수는 5자를 초과할 수 없습니다.");
        }
    }

    public static void validateDuplication(Set<String> names, String name) {
        if (!names.add(name)) {
            throw new IllegalArgumentException("중복된 차 이름입니다.");
        }
    }

    public static void validatePositive(int resultNum){
        //우승자는 한 명 이상일 수 있다
        if(resultNum <= 0){
            throw new IllegalArgumentException("게임 횟수는 0이하가 될 수 없습니다.");
        }
    }

}
