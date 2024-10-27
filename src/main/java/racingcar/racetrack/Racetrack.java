package racingcar.racetrack;

import java.util.List;
import racingcar.racer.Racer;
import racingcar.racer.car.Car;

public interface Racetrack<T> {
    public void run();
    public List<T> moveAll(List<T> objects);
    public List<String> findWinner(List<T> objects);
}
