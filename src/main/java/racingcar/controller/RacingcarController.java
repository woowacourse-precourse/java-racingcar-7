package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.domain.Racingcar;
import racingcar.service.RacingcarService;
import racingcar.utils.Utils;
import racingcar.view.InputView;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class RacingcarController {
    private RacingGame racingGame;

    private final RacingcarService racingcarService;

    public RacingcarController(RacingcarService racingcarService) {
        this.racingcarService = racingcarService;
    }

    public void run(){
        initRacingGame();

    }

    private void initRacingGame(){
        InputView.printInputRacingcarsMessage();
        List<Racingcar> racingcars = racingcarService.createRacingcars(inputRacingcarsName());
        racingGame = new RacingGame(racingcars);
    }

    private List<String> inputRacingcarsName(){
        String racingcarNameString = readLine().trim();
        return Utils.stringToList(racingcarNameString);
    }


}
