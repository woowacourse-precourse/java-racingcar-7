package racingcar;

import racingcar.race.Race;
import racingcar.separator.Extractor;
import racingcar.ui.UI;

public class Application {
    public static void main(String[] args) {
        Race race = new Race(Extractor.extract(UI.getRacerName()));
        race.startRace(UI.getRacingTimes());
    }
}
