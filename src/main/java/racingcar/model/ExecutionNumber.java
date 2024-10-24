package racingcar.model;

public record ExecutionNumber(Long number) {

    public long getNumber() {
        return number;
    }
}
