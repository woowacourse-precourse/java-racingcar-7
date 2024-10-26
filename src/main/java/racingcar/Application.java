package racingcar;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현

        CarRace race = new CarRace();
        GameInitializer.initGame(race);
        race.run();
    }
}
