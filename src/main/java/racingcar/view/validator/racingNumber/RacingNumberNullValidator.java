package racingcar.view.validator.racingNumber;

public class RacingNumberNullValidator extends RacingNumberValidator{

    @Override
    public void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("경주 횟수는 빈 문자열일 수 없습니다.");
        }
    }
}
