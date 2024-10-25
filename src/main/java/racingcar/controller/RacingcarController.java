package racingcar.controller;

import racingcar.domain.GameRound;
import racingcar.domain.RacingGame;
import racingcar.domain.Racingcars;
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
        String racingcarNamesString = readLine().trim();
        return Utils.stringToList(racingcarNamesString);
    }

    private int inputGameRoundCount(){
        InputView.printInputRacingCountMessage();
        return Utils.stringToInt(readLine().trim());
    }

    private void startRacingGame(){
        racingGame.startRacingGame();
    }

    public void afterRacingGame(){
        racingGame.printWinner();
    }
}
