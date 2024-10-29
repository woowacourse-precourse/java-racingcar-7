package racingcar.converter;

import java.util.List;
import racingcar.dto.RacingHistoryDto.RacingHistoryOutputDto;
import racingcar.model.domain.RacingHistory;

public class RacingHistoryConverter {
    public static List<RacingHistoryOutputDto> toRacingHistoryOutputDtoList(
            List<RacingHistory> racingHistoryList) {
        return racingHistoryList.stream()
                .map((history) ->
                        new RacingHistoryOutputDto(history.getCarName(), history.getRoundNumber(),
                                history.getTotalMovedDistance())
                ).toList();
    }
}
