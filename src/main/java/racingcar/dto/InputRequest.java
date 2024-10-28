package racingcar.dto;

public record InputRequest(String carNames, int roundCount) {

    public static InputRequest of(String carNames, int roundCount) {
        return new InputRequest(carNames, roundCount);
    }
}
