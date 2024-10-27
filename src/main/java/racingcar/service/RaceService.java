package racingcar.service;

import racingcar.domain.Car;
import racingcar.dto.UserInputDTO;
import racingcar.util.InputParser;
import racingcar.util.RaceUtils;

import java.util.List;

public class RaceService {

    private static final int MOVEMENT_THRESHOLD = 4;
    private long numOfStages;
    private List<Car> carList;
    private String winnerList;

    public void initialize(final UserInputDTO userInputDTO) {
        this.numOfStages = userInputDTO.numOfStages();
        this.carList = InputParser.getCarList(userInputDTO);
    }

    public void raceStart() {
        for (long i = 0; i < numOfStages; i++)
            raceInStage(i);
        raceOver();
    }

    public void raceInStage(final long stage) {
        for (Car car : carList) {
            if (canMove(car))
                car.move(stage);
            else
                car.stop(stage);
        }
    }

    public void raceOver() {
        this.winnerList = RaceUtils.getWinners(carList);
    }

    public boolean canMove(final Car car) {
        return car.getRandomNumber() >= MOVEMENT_THRESHOLD;
    }

    public long getNumOfStages() {
        return this.numOfStages;
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public String getWinnerList() {
        return this.winnerList;
    }
}