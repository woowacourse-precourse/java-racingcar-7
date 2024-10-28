package racingcar.service;

import racingcar.dto.RacingcarResults;

import java.util.List;

public interface RacingcarService {

    void setRacingcars(List<String> input);

    RacingcarResults racing();

    List<String> findWinner();
}
