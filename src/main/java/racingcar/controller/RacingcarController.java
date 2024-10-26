package racingcar.controller;

import racingcar.model.RacingGame;
import racingcar.model.Racingcar;
import racingcar.view.InputView;
import racingcar.view.OutputView;


import java.util.ArrayList;
import java.util.List;

public class RacingcarController {

    public void start() {
        Object[] inputNameAndCount = InputView.racingcarInputView();
        String racingcarNames = inputNameAndCount[0].toString();
        int moveCount = Integer.parseInt(inputNameAndCount[1].toString());

        List<Racingcar> racingcarsList = createRacingcars(racingcarNames);
        RacingGame racingGame = new RacingGame(racingcarsList, moveCount);

    }


    public void RunGame(RacingGame racingGame, List<Racingcar> racingcarList, int moveCount) {
        for(int i = 0; i < moveCount; i++) {
            racingGame.MoveRacingcars();
            OutputView.racingcarOutputView(racingGame.getCarsLocation());

        }
    }




    public List<Racingcar> createRacingcars(String racingcarNames) {
        String[] racingcars = racingcarNames.split(",");
        List<Racingcar> racingcarsList = new ArrayList<>();

        for(String racingcarName : racingcars) {
            racingcarName = racingcarName.trim();
            if (racingcarName.length() > 5) {
                throw new IllegalArgumentException();
            }
            racingcarsList.add(new Racingcar(racingcarName));
        }
        return racingcarsList;
    }
}
