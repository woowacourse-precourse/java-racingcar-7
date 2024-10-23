package racingcar;

import racingcar.io.ConsoleInputReceiver;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ConsoleInputReceiver console = new ConsoleInputReceiver();
        RaceManager racingController = new RaceManager(console);
        racingController.run();
    }
}
