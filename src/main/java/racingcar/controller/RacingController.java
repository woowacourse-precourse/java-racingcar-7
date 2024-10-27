package racingcar.controller;

import java.util.LinkedHashMap;
import racingcar.model.InputParser;
import racingcar.model.RacingModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputParser parser;
    private final RacingModel model;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputParser parser, RacingModel model, InputView inputView, OutputView outputView) {
        this.parser = parser;
        this.model = model;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void race() {
        LinkedHashMap<String, Integer> cars = parser.parseCars(inputView.getCars());
        int rounds = parser.parseRounds(inputView.getRounds());

        outputView.printStart();
        for (int round = 0; round < rounds; round++) {
            cars = model.moveCars(cars);
            outputView.printRound(cars);
        }

        outputView.printWinners(model.getWinners(cars));
    }
}
