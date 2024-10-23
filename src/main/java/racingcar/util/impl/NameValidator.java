package racingcar.util.impl;

import java.util.List;
import racingcar.util.Validator;

public class NameValidator implements Validator {
    @Override
    public void validate(Object o) {
        List<String> list = (List<String>) o;

        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        for (String s : list) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
