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

        if (hasDuplicate(names)) {
            throw new IllegalArgumentException("중복된 이름이 입력되었습니다. 서로 다른 이름을 입력해주십시오.");
        }

        if (isMoreThan5Letters(names)) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하로 입력해주십시오.");
        }
    }

    private boolean hasDuplicate(List<String> names) {
        long before = names.size();
        long after = names.stream().distinct().count();

        return before != after;
    }

    private boolean isMoreThan5Letters(List<String> names) {
        boolean isValid = names.stream()
                .anyMatch(name -> name.length() > 5);

        return isValid;
    }
}
