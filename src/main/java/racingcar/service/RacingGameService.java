package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGames;
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

        return new ResultDTO(cars, racingGames, getMaxProgressCars(cars));
    }

    public static String getMaxProgressCars(Cars cars){
        List<String> maxProgressCarNames = new ArrayList<>();
        int maxProgress = cars.findCarByNumber(0).getCurrentProgress();

        for (Car car : cars.getCars()) {
            if (car.getCurrentProgress() > maxProgress) {
                maxProgress = car.getCurrentProgress(); // 새로운 최대값 갱신
            }
        }

        for (Car car : cars.getCars()) {
            if (car.getCurrentProgress() == maxProgress) {
                maxProgressCarNames.add(car.getCarName());
            }
        }

        return String.join(", ", maxProgressCarNames);
    }
}
