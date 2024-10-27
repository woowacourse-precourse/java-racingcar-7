package racingcar.model;

import java.math.BigInteger;

public class AttemptCount {
    private BigInteger count;

    public AttemptCount(String count) {
        this.count = convertToBigInteger(count);
    }

    private BigInteger convertToBigInteger(String count) {
        try {
            return new BigInteger(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 숫자 형식입니다.");
        }
    }
}
