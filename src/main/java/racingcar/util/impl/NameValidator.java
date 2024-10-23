package racingcar.util.impl;

import java.util.List;
import racingcar.util.Validator;

public class NameValidator implements Validator {
    @Override
    public void validate(Object o) {
        List<String> list = (List<String>) o;

        if (list.isEmpty() || list.contains("")) {
            throw new IllegalArgumentException("자동차의 이름을 입력해주십시오.");
        }

        for (String s : list) {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5자 이하로 입력해주십시오.");
            }
        }
    }
}
