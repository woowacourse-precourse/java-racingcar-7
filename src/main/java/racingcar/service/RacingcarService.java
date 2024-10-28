package racingcar.service;

import java.util.List;

public interface RacingcarService {

    void initializeCars(String name);

    void moveCars();

    String getRoundStatus();

    List<String> findWinners();
}
