package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    public static void validateCarNameLength(String name){
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static void validateDuplicateName(List<String> names){
        Set<String> checkDuplicateNames = new HashSet<>(names);
        if (checkDuplicateNames.size() != names.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public static void validateCarsCount(List<String> names){
        if(names.size() < 2){
            throw new IllegalArgumentException("자동차는 최소 2대 이상이어야 합니다.");
        }
    }

    public static void validateCarNameIsEmpty(String name){
        if (name.isEmpty()){
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }
    }

    public static void validateGameCount(int gameCount){
        if (gameCount <= 0) {
            throw new IllegalArgumentException("게임 횟수는 1 이상이어야 합니다.");
        }
    }
}
