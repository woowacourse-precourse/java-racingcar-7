package racingcar.dto;

import java.util.List;

public record Winners(List<String> winners) {

    public String getWinners() {
        return String.join(", ", winners);
    }
}
