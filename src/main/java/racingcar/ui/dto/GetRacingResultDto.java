package racingcar.ui.dto;

import java.util.List;
import racingcar.domain.round.RoundResult;

public record GetRacingResultDto(String carName, int position) {

    public static List<GetRacingResultDto> from(List<RoundResult> racingResult) {
        return racingResult.stream()
                .map(result -> new GetRacingResultDto(result.carName(), result.position()))
                .toList();
    }

}
