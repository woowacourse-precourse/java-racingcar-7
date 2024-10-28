package racingcar.application.implement;

import java.util.List;

public interface RaceHistoryManager<T> {

    void record(List<T> racers);

    List<String> getAllHistory();
}
