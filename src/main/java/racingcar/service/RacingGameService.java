package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.racinggame.RacingGame;
import racingcar.domain.racinggame.RacingGames;
import racingcar.dto.RacingAttemptDTO;
import racingcar.dto.RacingCarNamesDTO;
import racingcar.dto.ResultDTO;

public class RacingGameService {
    public static ResultDTO runGame(RacingCarNamesDTO racingCarNamesDTO, RacingAttemptDTO racingAttemptDTO){
        RacingGames racingGames = new RacingGames();
        Cars cars = new Cars(racingCarNamesDTO);
        int attempts = racingAttemptDTO.getRacingAttempts();

        for(int i = 0; i < attempts; i++){
            RacingGame racingGame = new RacingGame();
            racingGame.startGame(cars);
            racingGames.addRacingGame(racingGame);
        }

        return new ResultDTO(printPlayingResult(racingGames, cars), getMaxProgressCars(cars));
    }

    public static String printPlayingResult(RacingGames racingGames, Cars cars){
        StringBuilder result = new StringBuilder();
        for(RacingGame racingGame : racingGames.getRacingGames()){
            result.append(racingGame.getFormattedGameResult(cars));
        }
        return result.toString();
    }

    public static String getMaxProgressCars(Cars cars){
        List<String> maxProgressCarNames = new ArrayList<>();
        int maxProgress = cars.getCarByNumber(0).getCurrentDistance();

        for (Car car : cars.getCars()) {
            if (car.getCurrentDistance() > maxProgress) {
                maxProgress = car.getCurrentDistance();
            }
        }

        for (Car car : cars.getCars()) {
            if (car.getCurrentDistance() == maxProgress) {
                maxProgressCarNames.add(car.getCarName());
            }
        }

        return String.join(", ", maxProgressCarNames);
    }
}
