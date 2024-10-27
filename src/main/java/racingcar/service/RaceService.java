package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.dto.UserInputDTO;
import racingcar.util.InputParser;
import racingcar.util.RaceUtils;

import java.util.List;

public class RaceService {

    private long numOfStages;
    private List<Car> carList;
    private String winnerList;

    public void initialize(final UserInputDTO userInputDTO) {
        this.numOfStages = userInputDTO.numOfStages();
        this.carList = InputParser.getCarList(userInputDTO);
    }

    public void raceStart() {
        for (long i = 0; i < numOfStages; i++)
            race(i);
        raceOver();
    }

    private void race(final long stage) {
        for (Car car : carList) {
            if (canMove())
                car.move(stage);
            else
                car.stop(stage);
        }
    }

    private void raceOver() {
        this.winnerList = RaceUtils.getWinners(carList);
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
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
