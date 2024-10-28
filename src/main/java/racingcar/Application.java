package racingcar;

import racingcar.config.Config;
import racingcar.domain.Race;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Race race = new Race(new Config());
        race.run();
    }
}
