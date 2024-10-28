// RacingCarController.java
package racingcar.controller;

import racingcar.model.Racer;
import racingcar.model.Round;
import racingcar.service.AcceleratorService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final AcceleratorService accelerator;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(AcceleratorService accelerator, InputView inputView, OutputView outputView) {
        this.accelerator = accelerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Racer racer = initializeRacer();
        Round round = initializeRound();

        outputView.printExecutionMessage();
        executeRounds(racer, round);
        printFinalWinner(racer);
    }

    private Racer initializeRacer() {
        return Racer.of(inputView.readCarNames());
    }

    private Round initializeRound() {
        return Round.of(inputView.readRound());
    }

    private void executeRounds(Racer racer, Round round) {
        while (round.hasMoreRounds()) {
            performRound(racer);
            round.keep();
        }
    }

    private void performRound(Racer racer) {
        racer.play(accelerator);
        outputView.printResult(racer.getResult());
    }

    private void printFinalWinner(Racer racer) {
        outputView.printFinalWinner(racer.getWinner().finalResult());
    }
}
