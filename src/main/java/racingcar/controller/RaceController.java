package racingcar.controller;

import racingcar.util.NameParser;
import racingcar.view.Input;

import java.util.ArrayList;

public class RaceController {
    public void playRace() {
        String names = Input.inputCarName();
        ArrayList<String> nameList = NameParser.parse(names);

        int turn = Input.inputRaceTurn();

    }
}
