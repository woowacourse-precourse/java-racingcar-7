package racingcar.race.track;

import java.util.List;

public interface RaceUtils<T> {
    public void moveAll(List<T> racers);
    public List<String> findWinner(List<T> racers);
}
