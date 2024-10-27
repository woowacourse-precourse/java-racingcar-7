package racingcar.validation;

public class CountValidation {
    public void validateNaturalNumber(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("입력된 값은 자연수여야 합니다: " + count);
        }
    }
}
