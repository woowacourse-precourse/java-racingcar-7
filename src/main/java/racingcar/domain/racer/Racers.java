package racingcar.domain.racer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Racers {

    private final List<Racer> racers;

    public Racers() {
        this.racers = new ArrayList<>();
    }

    public void register(Racer racer) {
        this.racers.add(racer);
    }

    public void moveCars() {
        this.racers.forEach(Racer::forward);
    }

    public List<Racer> getRacers() {
        return Collections.unmodifiableList(this.racers);
    }

}
