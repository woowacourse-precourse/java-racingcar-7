package racingcar.validation;

import java.util.List;

public class CountValidation {
    public void isValidateNaturalNumber(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("입력된 값은 자연수여야 합니다: " + count);
        }
    }
    public void validateCount(int count) {
        isValidateNaturalNumber(count);
    }
}
