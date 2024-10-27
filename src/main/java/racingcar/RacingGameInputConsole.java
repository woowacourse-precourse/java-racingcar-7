package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGameInputConsole implements GameInputView {
    @Override
    public void start() {
        Game game = createGame();
        game.play();
    }

    @Override
    public Game createGame() {
        String carNames = readCarsInput();
        Cars cars = Cars.createCarsFrom(carNames);

        String tryCountInput = readTryCountInput();
        RacingGameCount count = new RacingGameCount(tryCountInput);

        GameResultView resultView = new RacingGameOutPutConsole(cars);
        return new RacingGame(cars, count, resultView);
    }

    private String readCarsInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    private String readTryCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return readLine();
    }
}
