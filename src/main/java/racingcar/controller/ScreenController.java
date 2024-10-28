package racingcar.controller;

import java.util.List;
import racingcar.domain.LapScore;
import racingcar.domain.Race;
import racingcar.view.ScoreBoard;
import racingcar.view.constant.Output;

public class ScreenController {

    private static ScreenController instance;
    private Race race;

    private ScreenController() {}

    public static ScreenController getInstance() {
        if (instance == null) {
            instance = new ScreenController();
        }
        return instance;
    }

    public void connect(Race race) {
        System.out.println(ScoreBoard.initMessage());
        this.race = race;
    }

    private void printLap(List<LapScore> lapScores) {
        for (LapScore lapScore : lapScores) {
            printCarStatus(lapScore);
        }
        System.out.print(Output.SEPARATOR_BLANK_LINES);
    }

    private void printCarStatus(LapScore lapScore) {
        System.out.println(ScoreBoard.carStatus(
                lapScore.getCarName()
                ,lapScore.getScore())
        );
    }
}
