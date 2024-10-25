package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.Racingcar;
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
        List<Racingcar> racingcars = RacingGame.createRacingcars(inputRacingcarNames());
        int racingGameCount = inputRacingGameCount();
        racingGame = new RacingGame(racingcars, racingGameCount);
    }

    private List<String> inputRacingcarNames(){
        InputView.printInputRacingcarsMessage();
        String racingcarNamesString = readLine().trim();
        return Utils.stringToList(racingcarNamesString);
    }

    private int inputRacingGameCount(){
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
