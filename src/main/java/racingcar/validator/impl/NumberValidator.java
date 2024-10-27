package racingcar.validator.impl;

import racingcar.validator.Validator;

public class NumberValidator implements Validator {
    @Override
    public void validate(Object o) {
        try {
            int num = Integer.parseInt(o.toString());
            if (num < 0) {
                throw new IllegalArgumentException("양수를 입력해주십시오.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주십시오.");
        }
    }
}
