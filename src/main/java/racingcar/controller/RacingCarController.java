package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.view.ConsoleView;

public class RacingCarController {

    private final RacingGame racingGame;
    private final ConsoleView consoleView;

    public RacingCarController(RacingGame racingGame, ConsoleView consoleView){
        this.racingGame = racingGame;
        this.consoleView = consoleView;
    }

    public void run() {
        // 차 이름, 게임 횟수 입력
        String[] carNames = consoleView.inputCar();
        int round = consoleView.inputRound();

        // 게임 시작
        racingGame.initCars(carNames);

        for(int i=0; i<round; i++){
            racingGame.play();
        }

    }
}
