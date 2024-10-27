package racingcar.controller;

import java.util.LinkedHashMap;
import racingcar.model.InputParser;
import racingcar.model.RacingModel;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final InputParser parser;
    private final RacingModel racingModel;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputParser parser, RacingModel racingModel, InputView inputView, OutputView outputView) {
        this.parser = parser;
        this.racingModel = racingModel;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void race() {
        LinkedHashMap<String, Integer> cars = parser.parseCars(inputView.getCars());
        int rounds = parser.parseRounds(inputView.getRounds());

        outputView.printStart();
        for (int round = 0; round < rounds; round++) {
            cars = racingModel.moveCars(cars);
            outputView.printRound(cars);
        }

        outputView.printWinners(racingModel.getWinners(cars));
    }
}
