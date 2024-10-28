package racingcar.application.implement;

import java.util.List;

public interface RacingHistoryManager<T> {

    void record(List<T> racers);

    List<String> getAllHistory();
}
