package racingcar;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Race;
import racingcar.domain.Rounds;
import racingcar.view.Input;
import racingcar.view.Output;

public class Racing {

    private final NumberGenerator numberGenerator;
    private final Input input;
    private final Output output;

    public Racing(Input input, Output output, NumberGenerator numberGenerator) {
        this.input = input;
        this.output = output;
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

        output.printResultMessage();
        rounds.repeat(() -> {
            List<Car> cars = race.moveAll();
            output.printCarsStatus(cars);
        });

        finish(race);
    }

    private void finish(Race race) {
        race.findWinners();
    }
}
