package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.racinggame.RacingGame;
import racingcar.domain.racinggame.RacingGames;
import racingcar.domain.strategy.MoveStrategy;
import racingcar.domain.strategy.RandomMoveStrategy;
import racingcar.dto.RacingAttemptDTO;
import racingcar.dto.RacingCarNamesDTO;
import racingcar.dto.ResultDTO;

public class RacingGameService {
    public static ResultDTO runGame(RacingCarNamesDTO racingCarNamesDTO, RacingAttemptDTO racingAttemptDTO){
        RacingGames racingGames = new RacingGames();
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        Cars cars = new Cars(racingCarNamesDTO, moveStrategy);
        int attempts = racingAttemptDTO.getRacingAttempts();

        for(int i = 0; i < attempts; i++){
            RacingGame racingGame = new RacingGame(cars);
            racingGames.addRacingGame(racingGame);
        }

        return new ResultDTO(printPlayingResult(racingGames), getMaxDistanceCars(cars));
    }

    public static String printPlayingResult(RacingGames racingGames){
        StringBuilder result = new StringBuilder();
        for(RacingGame racingGame : racingGames.getRacingGames()){
            result.append(racingGame.getFormattedGameResult());
        }
        return result.toString();
    }

    public static String getMaxDistanceCars(Cars cars){
        int maxDistances = findMaxDistance(cars);
        return findWinnerCars(cars, maxDistances);
    }

    private static int findMaxDistance(Cars cars){
        return cars.getCars().stream()
                .mapToInt(Car::getCurrentDistance)
                .max()
                .orElse(0);
    }

    private static String findWinnerCars(Cars cars, int maxDistances){
        List<String> maxProgressCarNames = new ArrayList<>();
        for (Car car : cars.getCars()) {
            if (car.getCurrentDistance() == maxDistances) {
                maxProgressCarNames.add(car.getCarName());
            }
        }
        return String.join(", ", maxProgressCarNames);
    }
}
