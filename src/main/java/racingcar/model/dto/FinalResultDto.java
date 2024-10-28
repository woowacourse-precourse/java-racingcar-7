package racingcar.model.dto;

import java.util.List;

public record FinalResultDto(List<String> winners) {
    public String toString() {
        return String.join(", ", winners);
    }
}
