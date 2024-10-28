package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.MoveCondition;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGame;
import racingcar.dto.GameResult;
import racingcar.dto.RoundResults;

import java.util.List;

public class RacingService {

    public GameResult play(List<String> names, MoveCondition moveCondition, int count) {
        RacingGame game = new RacingGame(names, moveCondition, count);
        GameResult gameResult = new GameResult();
        getRoundResults(game, gameResult);
        getWinnersName(game, gameResult);
        return gameResult;
    }

    private void getRoundResults(RacingGame game, GameResult gameResult) {
        RoundResults roundResults = new RoundResults();
        while (game.isPlayable()) {
            RacingCars cars = game.playOneTime();
            roundResults.saveResult(cars.getCars());
        }
        gameResult.setRoundResults(roundResults);
    }

    private void getWinnersName(RacingGame game, GameResult gameResult) {
        List<Car> winners = game.getWinners();
        gameResult.setWinnerNames(winners.stream()
                .map(Car::getCarName)
                .toList());
    }
}
