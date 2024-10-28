package racingcar;

import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        CarRace race = new CarRace();
        try {
            GameInitializer.initGame(race);
            race.run();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
