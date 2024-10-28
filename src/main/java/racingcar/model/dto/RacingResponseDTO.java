package racingcar.model.dto;

public class RacingResponseDTO {
    private String racingResult;

    public String getRacingResult() {
        return racingResult;
    }

    private RacingResponseDTO(String racingResult) {
        this.racingResult = racingResult;
    }

    public static RacingResponseDTO create(String racingResult) {
        return new RacingResponseDTO(racingResult);
    }
}
