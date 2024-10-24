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
