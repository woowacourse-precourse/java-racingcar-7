package racingcar.domain;

import java.math.BigInteger;

public class TrialCountValidator {
    private static final BigInteger MAX_INT_VALUE = BigInteger.valueOf(Integer.MAX_VALUE);

    public static void validate(String trialCountInput){
        validateNumberFormat(trialCountInput);
        validateTrialCountSize(trialCountInput);
        validatePositiveInteger(trialCountInput);
    }

    private static void validateNumberFormat(String trialCountInput){
        if(!trialCountInput.matches("\\d+")){
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

    private static void validateTrialCountSize(String trialCountInput){
        BigInteger trialCountBigInt = new BigInteger(trialCountInput);
        if (trialCountBigInt.compareTo(MAX_INT_VALUE) > 0) {
            throw new IllegalArgumentException("시도 횟수가 너무 큽니다. " + Integer.MAX_VALUE + " 이하의 값을 입력하세요.");
        }
    }

    private static void validatePositiveInteger(String trialCountInput){
        int trialCountInt = Integer.parseInt(trialCountInput);
        if (trialCountInt <= 0) {
            throw new IllegalArgumentException("시도 횟수는 최소 1회 이상이어야 합니다.");
        }
    }
}
