package racingcar.service;

import racingcar.dto.GameResultDto;

public interface GameService {
    public void moveCarsRandomly();

    public GameResultDto getGameData();
}
