package racingcar.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racingcar.model.Game;
import racingcar.model.Movement;
import racingcar.model.Random;
import racingcar.model.Winner;
import racingcar.view.Input;
import racingcar.view.Output;

public class GameController {

    private Input input = new Input();
    private Output output = new Output();
    private Winner winner = new Winner();
    private Game game = new Game();
    private HashMap<String, Integer> raceStatus;
    private int attemptedNumber;

    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        raceStatus = input.getCarNames();
        System.out.println("시도할 횟수는 몇 회인가요?");
        attemptedNumber = input.getAttemptedNumber();
        System.out.println("\n실행 결과");
        for (int i = 0; i < attemptedNumber; i++) {
            raceStatus = game.play(raceStatus);
            output.printProgressByStage(raceStatus);
        }
        output.printWinners(winner.informWho(raceStatus));
    }
}
