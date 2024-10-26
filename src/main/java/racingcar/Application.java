package racingcar;

import java.util.List;

public class Application {

    // TODO: 참가자들 이름 겹치는 케이스 고려하기
    public static void main(String[] args) {
        RacingGameInput input = new RacingGameInput();
        List<String> carNames = input.readCarNames();
        int tryCount = input.readTryCount();

        Cars cars = Cars.withNames(carNames);
        RacingGame game = new RacingGame(cars, new RandomMoveCondition());
        RacingGameOutput output = new RacingGameOutput();
        output.gameStart();
        output.printRacingProgress(game, cars, tryCount);
        List<String> winners = game.getWinners(game.getPositions());
        output.printWinner(winners);
    }
}
