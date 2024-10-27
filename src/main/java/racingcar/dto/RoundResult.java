package racingcar.dto;

import java.util.List;
import racingcar.domain.Round;

public record RoundResult(List<CarRecord> carRecords) {
    public static RoundResult from(Round round) {
        return new RoundResult(round.getCars().stream()
                .map(CarRecord::from)
                .toList());
    }
}
