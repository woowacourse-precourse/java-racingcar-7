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
        Racer racer = Racer.of(inputView.readCarNames());
        Round round = Round.of(inputView.readRound());

        outputView.printExecutionMessage();
        while (round.hasMoreRounds()) {
            playRound(racer);
            round.keep();
        }

        // 중복된 최종 우승자 출력 제거
        outputView.printFinalWinner(racer.getWinner().finalResult());
    }

    private void playRound(Racer racer) {
        racer.play(accelerator);
        outputView.printResult(racer.getResult());
    }
}
