package racingcar.mvc.controller.racingGameManager;

import java.util.List;
import racingcar.mvc.model.observer.Racer;
import racingcar.mvc.model.subject.RacingGameRound;

public abstract class RacingGameManager {
    protected RacingGameRound gameRound;

    public abstract List<Racer> createRacers(String nameString);

    public abstract RacingGameRound setGameRound(RacingGameRound gameRound, List<Racer> racers);

    public abstract List<Racer> goRound();

    public abstract List<Racer> getWinners();
}
