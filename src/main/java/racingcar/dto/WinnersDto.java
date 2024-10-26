package racingcar.dto;

import java.util.List;
import racingcar.model.game.Game;

public record WinnersDto(
        List<String> nameOfWinners
) {
    public WinnersDto(Game game) {
        this(game.getNameOfWinners());
    }
}
