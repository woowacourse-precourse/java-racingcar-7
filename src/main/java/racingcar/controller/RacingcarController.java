package racingcar.controller;

import racingcar.model.GameRound;
import racingcar.model.RacingGame;
import racingcar.model.Racingcars;
import racingcar.utils.Utils;
import racingcar.view.InputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class RacingcarController {
    private RacingGame racingGame;

    public void run(){
        initRacingGame();
        startRacingGame();
        afterRacingGame();
    }

    private void initRacingGame(){
        Racingcars racingcars = new Racingcars(inputRacingcarNames());
        GameRound gameRound = new GameRound(inputGameRoundCount());
        racingGame = new RacingGame(racingcars, gameRound);
    }

    private List<String> inputRacingcarNames(){
        InputView.printInputRacingcarsMessage();
        return Utils.stringToList(readLine().trim());
    }

    private int inputGameRoundCount(){
        InputView.printInputRacingCountMessage();
        return Utils.stringToInt(readLine().trim());
    }

    private void startRacingGame(){
        racingGame.startRacingGame();
    }

    private void afterRacingGame(){
        racingGame.printWinner();
    }
}
