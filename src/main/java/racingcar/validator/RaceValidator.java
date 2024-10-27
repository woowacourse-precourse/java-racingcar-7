package racingcar.validator;

public class RaceValidator {

    public void validateAttempt(String inputAttempt) {
        if (inputAttempt == null || inputAttempt.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수를 입력해 주세요.");
        }
        try {
            Integer.parseInt(inputAttempt);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("유효한 시도 횟수를 입력해 주세요(자연수).");
        }
    }

}
