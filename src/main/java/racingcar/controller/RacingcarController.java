package racingcar.controller;

import racingcar.domain.RacingGame;
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
        racingGame = new RacingGame(inputRacingcarNames());
    }

    private List<String> inputRacingcarNames(){
        InputView.printInputRacingcarsMessage();
        String racingcarNamesString = readLine().trim();
        return Utils.stringToList(racingcarNamesString);
    }

    private void startRacingGame(){
        InputView.printInputRacingCountMessage();
        int racingGameCount = Utils.stringToInt(readLine().trim());
        racingGame.startRacingGame(racingGameCount);
    }

    public void afterRacingGame(){
        racingGame.printWinner();
    }
}
