package racingcar.controller;

import racingcar.view.UserView;
import racingcar.model.Race;

public class RaceController {

    private Race race;
    private UserView userView;

    public RaceController(UserView userView) {
        this.userView = userView;
    }

    public void run() {
        String[] carNames = userView.createCars();
        int round = userView.inputRoundCount();

        race = new Race(carNames);

        for (int i = 0; i < round; i++) {
            race.proceedRace(1);
            userView.displayRace(race.getCars());
        }

        userView.displayWinner(race.getWinners());
    }
}
