package racingcar.model.dto;

import java.util.Map;
import java.util.stream.Collectors;
import racingcar.model.Name;
import racingcar.model.Position;

public record RoundResultDto(Map<String, String> roundResult) {
    public static RoundResultDto of(Map<Name, Position> roundResult) {
        return new RoundResultDto(roundResult.entrySet().stream()
                .collect(
                        Collectors.toMap(
                                entry -> entry.getKey().getValue(),
                                entry -> entry.getValue().toString()
                        )
                )
        );
    }
}
