/*
 * NumberOfAttempts
 *
 * ver1
 *
 * 2024-10-24
 *
 * 저작권 주의
 */
package racingcar.domain;

import racingcar.dto.NumberOfAttemptsDTO;

public class NumberOfAttempts {
    private static final int MIN_ATTEMPTS = 1;
    private static final int MAX_ATTEMPTS = 20;

    private final int numberOfAttempts;

    public NumberOfAttempts(String readNumberOfAttempts) {
        int numberOfAttempts = integerParsing(readNumberOfAttempts);
        validationNumberOfAttempts(numberOfAttempts);
        this.numberOfAttempts = numberOfAttempts;
    }

    private int integerParsing(String readNumberOfAttempts) {
        try {
            return Integer.parseInt(readNumberOfAttempts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 정수만 가능합니다.");
        }
    }

    private void validationNumberOfAttempts(int readNumberOfAttempts) {
        if (readNumberOfAttempts < MIN_ATTEMPTS) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 " + MIN_ATTEMPTS + "이상만 가능합니다.");
        }
        if (readNumberOfAttempts > MAX_ATTEMPTS) {
            throw new IllegalArgumentException("[ERROR] 시도할 횟수는 " + MAX_ATTEMPTS + "이하만 가능합니다.");
        }
    }

    public NumberOfAttemptsDTO getNumberOfAttempts() {
        return new NumberOfAttemptsDTO(numberOfAttempts);
    }

}
