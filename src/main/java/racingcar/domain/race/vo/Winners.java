package racingcar.domain.race.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public record Winners(List<String> winnerNames) {

    private static final String WINNER_DELIMITER = ", ";

    @Override
    public String toString() {
        return winnerNames.stream()
            .collect(Collectors.joining(WINNER_DELIMITER));
    }
}
