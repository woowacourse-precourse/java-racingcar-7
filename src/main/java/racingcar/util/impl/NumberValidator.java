package racingcar.util.impl;

import racingcar.util.Validator;

public class NumberValidator implements Validator {
    @Override
    public void validate(Object o) {
        try {
            int num = Integer.parseInt(o.toString());
            if (num < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
