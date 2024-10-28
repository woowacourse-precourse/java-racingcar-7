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
        if(checkDuplicateNames.size() != names.size()){
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }
}
