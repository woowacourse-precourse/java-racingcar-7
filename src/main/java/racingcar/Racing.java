package racingcar;

import racingcar.domain.NumberGenerator;
import racingcar.domain.Race;
import racingcar.domain.Rounds;
import racingcar.view.Input;

public class Racing {

    private final NumberGenerator numberGenerator;
    private final Input input;

    public Racing(Input input, NumberGenerator numberGenerator) {
        this.input = input;
        this.numberGenerator = numberGenerator;
    }

    public void ready() {
        String rawCarNames = input.readCarNames();
        Race race = new Race(rawCarNames, numberGenerator);

        start(race);
    }

    private void start(Race race) {
        String rawCount = input.readCount();
        Rounds rounds = new Rounds(rawCount);

        rounds.repeat(race::moveAll);

        finish(race);
    }

    private void finish(Race race) {
        race.findWinners();
    }
}
