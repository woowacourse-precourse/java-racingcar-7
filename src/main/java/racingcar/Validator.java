package racingcar;

import java.util.Set;

public class Validator {

    public void nameValidation(String name, Set<String> nameSet) {
        if(name.length() > 5)
            throw new IllegalArgumentException("이름이 5글자를 초과했습니다.");
        if(nameSet.contains(name))
            throw new IllegalArgumentException("이미 존재하는 이름입니다.");
        if(name.isEmpty() || name.isBlank())
            throw new IllegalArgumentException("공백만 입력할 수 없습니다.");
    }

    public void countValidation(String count) {
        if(!count.matches("[+-]?\\d*(\\.\\d+)?"))
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        if(count.matches("-\\d+(\\.\\d+)?$"))
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        if(count.matches("[-+]?\\d*\\.\\d+$"))
            throw new IllegalArgumentException("소수는 입력할 수 없습니다.");
    }
}
