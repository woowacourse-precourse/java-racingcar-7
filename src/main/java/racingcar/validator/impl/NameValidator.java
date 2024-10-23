package racingcar.validator.impl;

import java.util.List;
import racingcar.validator.Validator;

public class NameValidator implements Validator {
    @Override
    public void validate(Object o) {
        List<String> names = (List<String>) o;

        if (names.isEmpty() || names.contains("")) {
            throw new IllegalArgumentException("자동차의 이름을 입력해주십시오.");
        }

        if (!checkDuplicate(names)) {
            throw new IllegalArgumentException("중복된 이름이 입력되었습니다. 서로 다른 이름을 입력해주십시오.");
        }

        if (!checkLength(names)) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하로 입력해주십시오.");
        }
    }

    private boolean checkDuplicate(List<String> names) {
        long before = names.size();
        long after = names.stream().distinct().count();

        return before == after;
    }

    private boolean checkLength(List<String> names) {
        boolean isValid = names.stream()
                .allMatch(name -> name.length() <= 5);

        return isValid;
    }
}
