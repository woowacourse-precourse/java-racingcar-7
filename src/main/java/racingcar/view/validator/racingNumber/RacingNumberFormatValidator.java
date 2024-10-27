package racingcar.view.validator.racingNumber;

public class RacingNumberFormatValidator extends RacingNumberValidator{

    @Override
    public void validate(String input) {
        try {
            long number = Long.parseLong(input);
            if (number <= 0) {
                throw new IllegalArgumentException("경주 횟수는 1 이상의 숫자이어야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("경주 횟수는 숫자이어야 합니다.");
        }
    }
}
