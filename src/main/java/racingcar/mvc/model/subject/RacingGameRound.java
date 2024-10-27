package racingcar.mvc.model.subject;

import java.util.ArrayList;
import java.util.List;
import racingcar.mvc.model.observer.Observer;
import racingcar.mvc.model.observer.Racer;

public class RacingGameRound implements Subject {
    private List<Racer> racers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        if (observer instanceof Racer) {
            racers.add((Racer) observer);
        }
    }

    @Override
    public void notifyObservers() {
        racers.forEach(observer -> observer.update());
    }

    public List<Racer> getRacers() {
        return racers;
    }
}
