package racingcar;

import racingcar.adapter.StringListAdapter;
import racingcar.common.Game;
import racingcar.controller.RacingController;
import racingcar.view.Input;
import racingcar.view.Output;

public class RacingGame {

    private final StringListAdapter stringListAdapter;
    private final RacingController racingController;

    public RacingGame() {
        stringListAdapter = new StringListAdapter();
        racingController = new RacingController();
    }

    public void startRacingGame() {
        Input input = new Input();
        Output output = new Output();
        Game game = new Game(stringListAdapter.parseCars(input.inputRacingCars()), stringListAdapter.parseCount(input.inputCount()));
        output.output(racingController.start(game));
    }
}
