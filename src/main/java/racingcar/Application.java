package racingcar;

import racingcar.race.Race;
import racingcar.ui.UI;

public class Application {
    public static void main(String[] args) {
        Race race = new Race(UI.inputRacerName());
        race.startRace(UI.inputRacingTimes());
    }
}
