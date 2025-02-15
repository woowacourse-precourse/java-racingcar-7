package racingcar.model.vo;

import java.math.BigInteger;

public record Round(int round) {
    private static final int MAX_ROUND = Integer.MAX_VALUE;

    public static Round fromString(String round) {
        validatePostiveNumber(round);
        validateExceedMaxRound(round);
        return new Round(Integer.parseInt(round));
    }

    private static void validatePostiveNumber(String round) {
        if (!round.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("라운드의 입력값은 숫자로만 이루어진 양수여야 합니다.");
        }
    }

    private static void validateExceedMaxRound(String round) {
        BigInteger roundNum = new BigInteger(round);
        BigInteger maxRound = new BigInteger(String.valueOf(MAX_ROUND));
        if(roundNum.compareTo(maxRound) > 0) {
            throw new IllegalArgumentException("라운드의 입력값은 2147483647을 초과할 수 없습니다.");
        }
    }
}
