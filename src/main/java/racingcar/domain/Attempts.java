package racingcar.domain;

public class Attempts {
    private static final String INVALID_ATTEMPTS_ERROR_MESSAGE = "시도 할 횟수는 1 이상의 정수여야 합니다";
    private static final int MIN_ROUND = 1;

    private int remainAttempts;

    public Attempts(String inputAttemptsNumber){
        validateNumber(inputAttemptsNumber);
        this.remainAttempts = Integer.parseInt(inputAttemptsNumber);
    }

    private void validateNumber(String inputAttemptsNumber){
        try{
            int inputAttempts = Integer.parseInt(inputAttemptsNumber);
            if(inputAttempts < MIN_ROUND){
                throw new IllegalArgumentException(INVALID_ATTEMPTS_ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ATTEMPTS_ERROR_MESSAGE);
        }
    }
}
