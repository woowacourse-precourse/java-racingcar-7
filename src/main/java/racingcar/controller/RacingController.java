package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;
    private final RacingService racingService;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.racingService = new RacingService();
        this.outputView = outputView;
    }

    public void run() {
        String inputString = inputView.inputString();

        List<String> carNames;

        try {
            carNames = racingService.separateInputString(inputString);
            racingService.checkValidCarName(carNames);
        } catch (IllegalArgumentException err) {
            throw err;
        }

        int gameRound;
        try{
            String round = inputView.inputGameRound();
            gameRound = Integer.parseInt(round);
        }catch(NumberFormatException err){
            throw new IllegalArgumentException("시도 횟수가 잘못 입력되었습니다.");
        }

        racingService.registrationCar(carNames);

        outputView.startGame();

        for (int i = 0; i < gameRound; i++) {
            List<String> roundResult = racingService.racing();
            outputView.roundResultView(carNames, roundResult);
        }

        String winner = racingService.getWinner();

        outputView.output(winner);
    }
}
