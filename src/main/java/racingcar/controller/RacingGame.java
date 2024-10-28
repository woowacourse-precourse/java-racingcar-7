package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.LongStream;
import racingcar.domain.CarFactory;
import racingcar.domain.Cars;
import racingcar.domain.MoveStrategy;
import racingcar.view.ResultView;

public class RacingGame {

    private static final String NON_NUMERIC_TRY_COUNT = "시도 횟수는 아라비아 숫자로 입력해야 합니다";

    private final String carNames;
    private Long tryCount;
    private final MoveStrategy moveStrategy;

    public RacingGame(String carNames, String tryCount, MoveStrategy moveStrategy) {
        this.carNames = carNames;
        this.tryCount = toLong(tryCount);
        this.moveStrategy = moveStrategy;
    }

    public void start() {
        Cars cars = registerCars();
        race(cars);
        announceWinners(cars);
    }

    private Cars registerCars() {
        return CarFactory.getInstance().createCars(carNames);
    }

    private Long toLong(final String textTryCount) {
        try {
            return Long.parseLong(textTryCount);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(NON_NUMERIC_TRY_COUNT);
        } finally {
            Console.close();
        }
    }

    private void race(Cars cars) {
        ResultView.promptExecutionResult();
        LongStream.range(0L, tryCount).forEach(count -> {
            cars.takeTurn(moveStrategy);
            ResultView.showTurnResult(cars);
        });
    }

    private void announceWinners(Cars cars) {
        ResultView.showWinners(cars.findWinners());
    }
}
