package racingcar;

import racingcar.domain.Race;
import racingcar.io.InputReader;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputReader inputReader = new InputReader();
        try {
            String[] carNames = inputReader.readLine1();
            int num = inputReader.readLine2();

            Race race = new Race(carNames, num);
            race.start();
        } catch (IllegalArgumentException e) {
            throw e;
        } finally {
            inputReader.close();
        }
    }
}
