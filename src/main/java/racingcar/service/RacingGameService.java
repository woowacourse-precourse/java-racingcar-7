package racingcar.service;

import racingcar.enums.CarState;
import racingcar.model.Car;
import racingcar.model.CarRoundResult;
import racingcar.model.RacingGame;
import racingcar.model.RoundResult;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    private final CarService carService;
    private static final int FORWARD_LIMIT = 4;

    public RacingGameService(CarService carService){
        this.carService = carService;
    }

    public RacingGame registerRacingGame(Integer totalRound, List<Car> racingCars){
        return new RacingGame(totalRound, racingCars);
    }

    public RacingGame racingGameProgress(RacingGame game){
        Integer totalRound = game.getTotalRound();
        List<Car> racingCars = game.getRacingCars();

        List<RoundResult> roundResults = new ArrayList<>();

        for(int round=1; round <= totalRound; round++){
            List<CarRoundResult> carRoundResults = new ArrayList<>();

            for(Car car: racingCars){
                CarRoundResult carRoundResult = carRoundStart(round, car);
                carRoundResults.add(carRoundResult);
            }

            int maxMoveCount = findMaxCount(carRoundResults);
            RoundResult roundResult = new RoundResult(round, carRoundResults, maxMoveCount);
            roundResults.add(roundResult);
        }

        game.setRoundResults(roundResults);

        return game;
    }

    public RacingGame findWinners(RacingGame game){
        RoundResult lastRoundResult = game.getRoundResults().getLast();
        int maxMoveCount = lastRoundResult.getMaxMoveCount();
        List<CarRoundResult> carRoundResults = lastRoundResult.getCarRoundResults();

        List<String> winners = new ArrayList<>();

        for(CarRoundResult result : carRoundResults){
            int count = result.getCurrentMoveCount();
            if(maxMoveCount == count){
                winners.add(result.getCarName());
            }
        }

        game.setWinners(winners);

        return game;
    }

    private CarRoundResult carRoundStart(Integer round, Car car){
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        CarState carState;

        if(randomNumber < FORWARD_LIMIT){
            carState = CarState.STOP;
        }
        else{
            carState = CarState.MOVING_FORWARD;
            carService.progressCar(car);
        }

        CarRoundResult result = new CarRoundResult(car.getName(), carState, randomNumber, car.getCurrentMoveCount());

        return result;
    }

    private Integer findMaxCount(List<CarRoundResult> carRoundResults){
        int maxMoveCount = 0;

        for(CarRoundResult result : carRoundResults){
            int count = result.getCurrentMoveCount();
            if(maxMoveCount < count){
                maxMoveCount = count;
            }
        }

        return maxMoveCount;
    }
}
