package racingcar.controller;

import racingcar.service.MoveDecision;
import racingcar.service.RaceLogic;
import racingcar.view.InputUser;
import racingcar.view.PrintResult;

import java.util.List;

public class GameController {
    private InputUser inputUser = new InputUser();
    private MoveDecision moveDecision = new MoveDecision();
    private RaceLogic raceLogic;
    PrintResult printResult = new PrintResult();

    public void startGame() {
        List<String> names = inputUser.inputNames();
        int number = inputUser.inputNumber();

        raceLogic = new RaceLogic(names, number, moveDecision);

        for (int i = 0; i < number; i++) {
            raceLogic.race(moveDecision.isFour(names));
            printResult.printRace(names, raceLogic.getRaceResult());
        }

        List<Integer> maxIndex = raceLogic.findWinners();

        printResult.printRaceResult(maxIndex, names);
    }

}
