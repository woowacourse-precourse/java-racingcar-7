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

    }

    private void initRacingGame(){
        racingGame = new RacingGame(inputRacingcarNames());
    }

    private List<String> inputRacingcarNames(){
        InputView.printInputRacingcarsMessage();
        String racingcarNamesString = readLine().trim();
        return Utils.stringToList(racingcarNamesString);
    }



}
