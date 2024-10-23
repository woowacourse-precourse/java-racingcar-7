package racingcar.runner;

import racingcar.core.RacingCarGame;
import racingcar.creator.RacingCarGameCreator;

public class RacingCarRunner {

    private final RacingCarGameCreator creator;
    private final RacingCarGame game;

    public RacingCarRunner() {
        InputReader reader = new InputReader(2);
        String cars = reader.getStringWithQuestion("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        int numOfAttempts = reader.getIntegerWithQuestion("시도할 횟수는 몇 회인가요?");

        this.creator = new RacingCarGameCreator(cars, numOfAttempts);
        this.game = new RacingCarGame(creator);
    }

    public void start() {
        game.start();
        game.printWinner();
    }
}
