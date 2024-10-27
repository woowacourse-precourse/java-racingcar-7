package racingcar;

import racingcar.domain.Race;
import racingcar.view.Input;

public class Racing {

    private final Input input;

    public Racing(Input input) {
        this.input = input;
    }

    public void ready() {
        String rawCarNames = input.readCarNames();
        Race race = new Race(rawCarNames);

        start(race);
    }

    private void start(Race race) {
        int lap = 5;
        for (int i = 0; i < lap; i++) {
            race.moveAll();
        }

        finish(race);
    }

    private void finish(Race race) {
        race.findWinners();
    }
}
