/*
 * NumberOfAttemptsDTO
 *
 * ver1
 *
 * 2024-10-24
 *
 * 저작권 주의
 */
package racingcar.dto;

public class NumberOfAttemptsDTO {
    private final int numberOfAttempts;

    public NumberOfAttemptsDTO(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public int getNumber() {
        return numberOfAttempts;
    }
}
