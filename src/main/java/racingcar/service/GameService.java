package racingcar.service;

import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;

public interface GameService<T, R> {
    R startGame(T request);
}
