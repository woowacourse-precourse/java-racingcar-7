package racingcar;

import racingcar.domain.RacingGame;
import racingcar.domain.RacingCars;
import racingcar.util.ConsoleIOHandler;
import racingcar.util.StringParser;

public class Application {
    public static void main(String[] args) {

        try (ConsoleIOHandler handler = new ConsoleIOHandler()) {
            String names = handler.read("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String times = handler.read("시도할 횟수는 몇 회인가요?");

            RacingGame racingGame = RacingGame.of(
                    RacingCars.from(StringParser.parseCarName(names)),
                    StringParser.parseInt(times));

            racingGame.start();
            RacingCars winners = racingGame.judge();
            handler.print(winners);
        }
    }
}
