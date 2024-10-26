package racingcar.dto;

import java.util.Map.Entry;
import racingcar.vo.Name;
import racingcar.vo.Position;

public record CarPositionDto(String name, int position) {
    public static CarPositionDto fromEntry(Entry<Name, Position> entry) {
        return new CarPositionDto(
                entry.getKey().getValue(),
                entry.getValue().getValue()
        );
    }
}