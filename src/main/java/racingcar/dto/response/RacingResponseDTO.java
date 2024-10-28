package racingcar.dto.response;

import java.util.List;

public record RacingResponseDTO(
        List<RoundResultDTO> roundResultDTOs,
        List<String> winnerNames
) {
    public static RacingResponseDTO of(List<RoundResultDTO> roundResultDTOs, List<String> winnerNames) {
        return new RacingResponseDTO(
                roundResultDTOs,
                winnerNames
        );
    }
}
