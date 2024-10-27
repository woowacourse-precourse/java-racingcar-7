package racingcar.model.dto;

import java.util.List;

public record Winners(
        List<String> winnerNames
) {

    public String getFormattedWinnerNames() {
        return String.join(", ", winnerNames);
    }
}
