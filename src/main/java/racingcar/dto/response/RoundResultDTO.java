package racingcar.dto.response;

import java.util.List;

public record RoundResultDTO(
        List<CarRoundStateDTO> carRoundStateDTOs
) {
    public static RoundResultDTO of(List<CarRoundStateDTO> carRoundStateDTOs) {
        return new RoundResultDTO(carRoundStateDTOs);
    }
}
