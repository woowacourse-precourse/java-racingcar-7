package racingcar.dto;

import java.util.List;

public record FinalResultDto(
        List<RoundResultDto> roundResultList,
        List<String> winnerList
) {
}
