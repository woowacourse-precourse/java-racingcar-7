package racingcar.dto;

import racingcar.domain.RaceFormatter;

public record CarMoveHistoryDto(String carName, String carMoveHistory) {
    @Override
    public String toString(){
        return RaceFormatter.formatCarMoveHistory(this);
    }
}
