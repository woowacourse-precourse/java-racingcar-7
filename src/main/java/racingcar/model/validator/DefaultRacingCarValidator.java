package racingcar.model.validator;

public class DefaultRacingCarValidator implements RacingCarValidator {

    private final int MAX_NAME_LENGTH = 5;

    @Override
    public void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다.");
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }
}
