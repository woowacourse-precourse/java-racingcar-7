package racingcar.model.dto;

public class RacingRequestDTO {
    private String inputNames;
    private String roundCount;

    public RacingRequestDTO(String inputNames, String roundCount) {
        this.inputNames = inputNames;
        this.roundCount = roundCount;
    }

    public String getRoundCount() {
        return roundCount;
    }

    public String getInputNames() {
        return inputNames;
    }

    public static RacingRequestDTO create(String inputNames, String roundCount) {
        return new RacingRequestDTO(inputNames, roundCount);
    }
}
