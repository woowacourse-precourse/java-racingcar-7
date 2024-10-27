package racingcar;

import racingcar.service.Race;
import racingcar.dto.InputDTO;
import racingcar.io.RacingCarIO;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputDTO inputs = RacingCarIO.getInput();
        Race race = new Race( inputs );

        race.start();

        race.end();
    }
}
